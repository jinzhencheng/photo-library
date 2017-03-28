package jh.studio.ctl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.condition.OpinionCond;
import jh.studio.dal.OpinionDal;
import jh.studio.entity.Condition;
import jh.studio.entity.Opinion;
import jh.studio.entity.Pagination;

public class OpinionAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private String content;
	private String result;
	private Opinion opinion=new Opinion();
	private int page;
	private int rows;
	private Map<String, Object> results = new HashMap<String, Object>();
	
	

	public Opinion getOpinion() {
		return opinion;
	}
	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}
	public Map<String, Object> getResults() {
		return results;
	}
	public void setResults(Map<String, Object> results) {
		this.results = results;
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
	public String add()throws Exception{
		Date date=new Date();
		content=new String(content.getBytes("iso8859_1"),"utf-8");
		Opinion entity=new Opinion();
		entity.setContent(content);
		entity.setTheDate(date);
		OpinionDal dal=new OpinionDal();
		dal.add(entity);
		dal.dispose();
		result="finished";
		return SUCCESS;
	}
    public String find(){
		Condition condition=new OpinionCond(opinion.getContent());
		Pagination pager = new Pagination();
		pager.setPage(page);
		pager.setRows(rows);
		OpinionDal dal=new OpinionDal();
		List<Opinion> result=dal.search(condition, pager);
		dal.dispose();
		int total = pager.getTotal();
		results.put("rows", result);
		results.put("total", total);
		return "ok";
    	
    }
	public void setContent(String content) {
		this.content = content;
	}

	public String getResult(){
		return result;
	}
	
}
