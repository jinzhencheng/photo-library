package jh.studio.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.condition.TagCond;
import jh.studio.dal.CategoryAgentDal;
import jh.studio.dal.CategoryDal;
import jh.studio.dal.TagDal;
import jh.studio.entity.Category;
import jh.studio.entity.CategoryAgent;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;

public class TagAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private int page;
	private int rows;
	private Tag tag=new Tag();
	private String result;
	private Map<String,Object> resultMap;
	private List<Tag> tags=null;
	private int tagId;
	private String categoryIds;
	private String tagName;
	private int clickCount;
	private int isHots;

	public String list(){
		Condition condition=new TagCond(tag.getName()); 
		Pagination pager=new Pagination();
		pager.setPage(page);
		pager.setRows(rows);

		TagDal dal=new TagDal();
		List<Tag> tags=dal.search(condition, pager);
		dal.dispose();

		int total=pager.getTotal();
		resultMap=new HashMap<String,Object>();
		resultMap.put("rows",tags);
		resultMap.put("total",total);
		return "list";
	} 

	public String fetchHotTag(){
		TagDal dal=new TagDal();
		tags=dal.getHot();
		dal.dispose();
		return "fetchHotTag";
	}

	public String fetchOne(){
		TagDal dal=new TagDal();
		this.tag=dal.getOne(tag.getId());
		dal.dispose();
		return "fetchOne";
	}
	
	public String fetchAll()
	{
		TagDal tagDal=new TagDal();
		this.tags=tagDal.getAll(Pagination.NULL);
		tagDal.dispose();
		return "fetchAll";
	}
	
	public void delTag()
	{
		TagDal dal = new TagDal();
		Tag t = dal.getOne(tagId);
		if(t == null)
		{
			dal.dispose();
			result="finished";
		}
		else
		{
			t.setIsValid(0);
			dal.update(t);
			dal.dispose();
		}
		result="finished";
	}
	
	
	public void save(){
		TagDal dal=new TagDal();
		
		Tag t = dal.getOne(tagId);
		
		if(t != null)
		{	
			Tag tt = new Tag();
			tt.setId(tagId);
			tt.setName(tagName);
			if(isHots == 1)
			{
				tt.setIsHot(true);
			}
			else
			{
				tt.setIsHot(false);
			}
			dal.updateTag(tt);
			dal.dispose();
			
			Set<CategoryAgent> set = t.getCategoryIds();
			List<CategoryAgent> insertList = new ArrayList<CategoryAgent>();
			List<Integer> delList = new ArrayList<Integer>();
			
			for(CategoryAgent c:set)
			{
				String id = c.getCategoryId().getId()+"";
				if(c.getTagId().getId() == tagId && !categoryIds.contains(id))
				{
					delList.add(c.getCategoryId().getId());
				}
			}
			
			String ids = "";
			for(CategoryAgent c:set)
			{
				ids += c.getCategoryId().getId();
			}
			String[] categoryIdArray = categoryIds.split("-");
			for(String c:categoryIdArray)
			{
				if(!ids.contains(c))
				{
					CategoryAgent ca = new CategoryAgent();
					
					Tag t1 = new Tag();
					t1.setId(tagId);
					
					Category cg = new Category();
					cg.setId(Integer.parseInt(c));
					ca.setCategoryId(cg);
					ca.setTagId(t1);
					
					insertList.add(ca);
				}
			}
			
			CategoryAgentDal cgAgentDal = new CategoryAgentDal();
			cgAgentDal.batchDel(delList,tagId);
			cgAgentDal.batchAdd(insertList);
			cgAgentDal.dispose();
		}
		else
		{
			Set<CategoryAgent> categorySet = new HashSet<CategoryAgent>();
			CategoryDal cDal = new CategoryDal();
			List<Category> categoryList = cDal.getCategory(categoryIds);
			cDal.dispose();
			
			Tag tag = new Tag();
			tag.setId(tagId);
			tag.setName(tagName);
			tag.setClickCount(clickCount);
			tag.setIsValid(1);//有效
			if(isHots == 1)
			{
				tag.setIsHot(true);
			}
			else
			{
				tag.setIsHot(false);
			}
			for(Category c:categoryList)
			{
				CategoryAgent ca = new CategoryAgent();
				ca.setCategoryId(c);
				ca.setTagId(tag);
				categorySet.add(ca);
			}
			tag.setCategoryIds(categorySet);
			dal.add(tag);
			dal.dispose();
		}
		result="finished";
	}

	
	public Map<String,Object> getResultMap(){
		return resultMap;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows= rows;
	}
	public Tag getTag(){
		return tag;
	}
	public void setTag(Tag tag){
		this.tag=tag;
	}
	public String getResult() {
		return result;
	}
	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(String categoryIds) {
		this.categoryIds = categoryIds;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public int getIsHots() {
		return isHots;
	}

	public void setIsHots(int isHots) {
		this.isHots = isHots;
	}
}
