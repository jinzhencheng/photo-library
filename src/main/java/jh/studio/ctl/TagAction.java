package jh.studio.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.condition.TagCond;
import jh.studio.dal.TagDal;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;

public class TagAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private int page;
	private int rows;
	private int id;
	private int clickCount;
	private String name;
	private Tag tag;
	private String categoryIds;
	private String result;
	private Map<String,Object> resultMap;


	public String list(){
		Condition condition=new TagCond(name); 
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

	public String fetchOne(){
		TagDal dal=new TagDal();
		this.tag=dal.getOne(id);
		dal.dispose();
		return "fetchOne";
	}
	
	public String save(){
		Tag tag=new Tag();
		tag.setId(id);
		tag.setName(name);
		tag.setClickCount(clickCount);
		tag.setCategoryIds(translate());
		System.out.println(id + " " + name + " "+categoryIds);
		TagDal dal=new TagDal();
		dal.saveOrUpdate(tag);
		dal.dispose();
		result="finished";
		return "edit";
	}

	private List<Integer> translate(){
		List<Integer> cateIdList=new ArrayList<Integer>();
		if(StringUtils.isNotEmpty(categoryIds)){
			String cateIdAry[]=categoryIds.split("-");
			for(String id:cateIdAry){
				cateIdList.add(Integer.valueOf(id));
			}
		}
		return cateIdList;

	}
	public Map<String,Object> getResultMap(){
		return resultMap;
	}
	public void setId(int id){
		this.id=id;
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
	public String getName() {
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public Tag getTag(){
		return tag;
	}
	public String getResult() {
		return result;
	}
	public void setCategoryIds(String categoryIds) {
		this.categoryIds = categoryIds;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	
	
}
