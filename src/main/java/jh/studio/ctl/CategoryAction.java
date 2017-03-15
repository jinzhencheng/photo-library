package jh.studio.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.condition.CategoryCond;
import jh.studio.condition.TagCond;
import jh.studio.dal.CategoryAgentDal;
import jh.studio.dal.CategoryDal;
import jh.studio.dal.TagDal;
import jh.studio.entity.Category;
import jh.studio.entity.CategoryAgent;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;

public class CategoryAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private List<Category> categories=null;
	private int page;
	private int rows;
	private Map<String,Object> resultMap;
	private Category category = new Category();
	private int categoryId;
	private String tagIds;
	private String categoryName;
	private int categorySequence;
	
	public String fetchAll(){
		CategoryDal dal=new CategoryDal();
		this.categories=dal.getAll(Pagination.NULL);
		dal.dispose();
		return "fetchAll";
	}
	
	
	public String list(){
		Condition condition=new CategoryCond(category.getName()); 
		Pagination pager=new Pagination();
		pager.setPage(page);
		pager.setRows(rows);

		CategoryDal cgDal=new CategoryDal();
		List<Category> tags=cgDal.search(condition, pager);
		cgDal.dispose();

		int total=pager.getTotal();
		resultMap=new HashMap<String,Object>();
		resultMap.put("rows",tags);
		resultMap.put("total",total);
		return "list";
	}

	public String fetchOne()
	{
		CategoryDal categoryDal=new CategoryDal();
		this.category=categoryDal.getOne(category.getId());
		categoryDal.dispose();
		return "fetchOne";
	}
	public void delCategory()
	{
		CategoryDal dal = new CategoryDal();
		Category t = dal.getOne(categoryId);
		if(t == null)
		{
			dal.dispose();
		}
		else
		{
			t.setIsValid(0);
			dal.update(t);
			dal.dispose();
		}
	}
	public void save(){
		CategoryDal dal=new CategoryDal();
		Category t = dal.getOne(categoryId);
		if(t != null)
		{
			dal.dispose();
			//Êý¾Ý¿âÖÐ£¬Ô­ÏÈµÄ·ÖÀà¼¯ºÏ
			Set<CategoryAgent> set = t.getTags();
			List<CategoryAgent> insertList = new ArrayList<CategoryAgent>();
			List<Integer> delList = new ArrayList<Integer>();
			
			for(CategoryAgent c:set)
			{
				String id = c.getTagId().getId()+"";
				if(c.getCategoryId().getId() == categoryId && !tagIds.contains(id))
				{
					delList.add(c.getTagId().getId());
				}
			}
			
			String ids = "";
			for(CategoryAgent c:set)
			{
				ids += c.getTagId().getId();
			}
			String[] tagIdArray = tagIds.split("-");
			for(String c:tagIdArray)
			{
				if(!ids.contains(c))
				{
					CategoryAgent ca = new CategoryAgent();
					
					Tag t1 = new Tag();
					t1.setId(Integer.parseInt(c));
					
					Category cg = new Category();
					cg.setId(categoryId);
					
					ca.setCategoryId(cg);
					ca.setTagId(t1);
					
					insertList.add(ca);
				}
			}
			
			CategoryAgentDal cgAgentDal = new CategoryAgentDal();
			cgAgentDal.batchDelByCategory(delList,categoryId);
			cgAgentDal.batchAdd(insertList);
			cgAgentDal.dispose();
		}
		else
		{
			Set<CategoryAgent> tagSet = new HashSet<CategoryAgent>();
			TagDal tDal = new TagDal();
			List<Tag> tagList = tDal.getTag(tagIds);
			tDal.dispose();
			
			Category category = new Category();
			category.setId(categoryId);
			category.setName(categoryName);
			category.setSequence(categorySequence);
			category.setIsValid(1);//ÓÐÐ§
			
			for(Tag c:tagList)
			{
				CategoryAgent ca = new CategoryAgent();
				ca.setCategoryId(category);
				ca.setTagId(c);
				tagSet.add(ca);
			}
			category.setTags(tagSet);
			dal.add(category);
			dal.dispose();
		}
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
		this.rows = rows;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	} 
	public List<Category> getCategories(){
		return this.categories;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getTagIds() {
		return tagIds;
	}


	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public int getCategorySequence() {
		return categorySequence;
	}


	public void setCategorySequence(int categorySequence) {
		this.categorySequence = categorySequence;
	}
	
	

}
