package jh.studio.dal;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.Query;

import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;
import jh.studio.inter.IDal;

public class TagDal extends BaseDal implements IDal<Tag>{

	@Override
	public void add(Tag entity){
		if(entity==null)
			return;
		super.session.save(entity);
		super.transaction.commit();
	}

	@Override
	public void update(Tag entity) {
		if(entity==null || entity.getId()==0)
			return;
		super.session.save(entity);
		super.transaction.commit();
	}

	@Override
	public void delete(Tag entity) {
		if(entity==null || entity.getId()==0)
			return;
		super.session.delete(entity);
		super.transaction.commit();
	}

	@Override
	public List<Tag> getAll(Pagination page) {
		String sql="from Tag";
		int pageSize=page.getPageSize();
		int pageIndex=page.getIndex();
		Query<Tag> query=super.session.createQuery(sql,Tag.class);
		List<Tag> list=query.setFirstResult((pageIndex - 1) * pageSize)
				.setMaxResults(pageSize)
				.getResultList();
		
		return list;
	}

	@Override
	public List<Tag> search(Condition condition, Pagination page) {
		String sql="from Tag where 1=1 ";
		boolean hasName=false;
		if(condition!=null){
			hasName=StringUtils.isNotEmpty(condition.getName());
			if(hasName){
				sql+="and name like :name";
			}
		}
		Query<Tag> query=super.session.createQuery(sql,Tag.class);
		if(hasName){
			query.setParameter("name",condition.getName());
		}
		int pageSize=page.getPageSize();
		int pageIndex=page.getIndex();
		List<Tag> list=query.setFirstResult((pageIndex - 1) * pageSize)
				.setMaxResults(pageSize)
				.getResultList();
		return list;
	}

}

