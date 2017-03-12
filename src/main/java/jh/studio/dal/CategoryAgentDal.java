package jh.studio.dal;

import java.util.List;

import jh.studio.entity.CategoryAgent;

public class CategoryAgentDal extends BaseDal<CategoryAgent>{

	public void delete(int tagId){
		String hql="from CategoryAgent c where c.tagId="+tagId;
		super.session.delete(hql);
		super.transaction.commit();
	}

	public void batchAdd(List<CategoryAgent> list){
		for(CategoryAgent agent:list){
			super.session.save(agent);
		}
		super.transaction.commit();
	}
}
