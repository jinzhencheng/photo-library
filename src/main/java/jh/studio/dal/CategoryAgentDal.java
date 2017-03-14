package jh.studio.dal;

import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.CategoryAgent;

public class CategoryAgentDal extends BaseDal<CategoryAgent>{

	public List<CategoryAgent> searchByTag(int tagId){
		String hql="from CategoryAgent c where c.tagId="+tagId;
		Query<CategoryAgent> query=super.session.createQuery(hql,CategoryAgent.class);
		return query.getResultList();
	}

	public void deleteByTag(int tagId){
		String sql="delete from category_agent where tag_id="+tagId;
		super.session.createNativeQuery(sql).executeUpdate();
	}
	public void batchAdd(List<CategoryAgent> list){
		for(CategoryAgent agent:list){
			String sql="insert into category_agent values(0,"+agent.getTagId()+","+agent.getCategoryId()+")";
			super.session.createNativeQuery(sql).executeUpdate();
		}
	}
}
