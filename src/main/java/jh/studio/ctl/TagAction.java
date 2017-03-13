package jh.studio.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Tag tag=new Tag();
	private String result;
	private Map<String,Object> resultMap;


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

	public String fetchOne(){
		TagDal dal=new TagDal();
		this.tag=dal.getOne(tag.getId());
		dal.dispose();
		return "fetchOne";
	}
	
	public String save(){
		TagDal dal=new TagDal();
		dal.saveOrUpdate(tag);
		dal.dispose();
		result="finished";
		return "edit";
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
	
}
