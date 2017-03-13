package jh.studio.dal;

import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.CategoryAgent;

public class CategoryAgentDal extends BaseDal<CategoryAgent>{

	public void delete(int tagId){
		String hql="from CategoryAgent c where c.tagId="+tagId;
		super.session.delete(hql);
		super.transaction.commit();
	}

	public List<CategoryAgent> searchByTag(int tagId){
		String hql="from CategoryAgent c where c.tagId="+tagId;
		Query<CategoryAgent> query=super.session.createQuery(hql,CategoryAgent.class);
		return query.getResultList();
	}

	public void deleteByTag(int tagId){
		String sql="delete from category_agent where tag_id="+tagId;
		super.session.createNativeQuery(sql).executeUpdate();
		super.transaction.commit();
	}
	public void batchAdd(List<CategoryAgent> list){
		for(CategoryAgent agent:list){
			super.session.save(agent);
		}
		super.transaction.commit();
	}
}
