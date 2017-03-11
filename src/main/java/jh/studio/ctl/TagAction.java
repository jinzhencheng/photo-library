package jh.studio.ctl;

import java.util.ArrayList;
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
	private String name;
	private List<Tag> tags=new ArrayList<Tag>();
	private Map<String,Object> results=new HashMap<String,Object>();


	public String execute(){
		Condition condition=new TagCond(name); 
		Pagination pager=new Pagination();
		pager.setPage(page);
		pager.setRows(rows);

		TagDal dal=new TagDal();
		List<Tag> tags=dal.search(condition, pager);
		dal.dispose();
		int total=pager.getTotal();
		results.put("rows",tags);
		results.put("total",total);
		return SUCCESS;
	} 

	public Map<String,Object> getResults(){
		return results;
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
	public List<Tag> getTags() {
		return tags;
	}
	public String getName() {
		return name;
	}

	}
