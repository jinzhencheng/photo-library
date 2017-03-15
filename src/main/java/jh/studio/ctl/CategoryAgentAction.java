package jh.studio.ctl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.CategoryAgentDal;
import jh.studio.entity.CategoryAgent;

public class CategoryAgentAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private List<CategoryAgent> agents;
	private int tagId;
	private String categoryIds;
	private int categoryId;
	
	public String fetchByTag(){
		CategoryAgentDal dal=new CategoryAgentDal();
		agents=dal.searchByTag(tagId);
		dal.dispose();
		return "fetchByTag";
	}
	
	public String fetchByCategory()
	{
		CategoryAgentDal dal=new CategoryAgentDal();
		agents=dal.searchByCategory(categoryId);
		dal.dispose();
		return "fetchByCategory";
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
//	public String save(){
//		List<Integer> list=translate();
//		List<CategoryAgent> agentList=new ArrayList<CategoryAgent>();
//		for(int categoryId:list){
//			CategoryAgent agent=new CategoryAgent();
//			/*agent.setTagId(tagId);
//			agent.setCategoryId(categoryId);*/
//			agentList.add(agent);
//		}
//		CategoryAgentDal dal=new CategoryAgentDal();
//		dal.deleteByTag(tagId);
//		dal.batchAdd(agentList);
//		dal.dispose();
//		return "save";
//	}

	public List<CategoryAgent> getAgents() {
		return agents;
	}
	
	public void setTagId(int tagId) {
		this.tagId=tagId;
	}

	public void setCategoryIds(String categoryIds) {
		this.categoryIds = categoryIds;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
