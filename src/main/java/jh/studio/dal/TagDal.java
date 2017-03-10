package jh.studio.dal;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;
import jh.studio.inter.IDal;

public class TagDal extends BaseDal<Tag> implements IDal<Tag>{

	private Logger logger=null;

	public TagDal(){
		logger=Logger.getLogger(TagDal.class);
	}

	@Override
	public void add(Tag entity){
		if(entity==null){
			logger.error("添加对象为空");
			return;
		}
		super.session.save(entity);
		super.transaction.commit();
	}

	@Override
	public void update(Tag entity) {
		if(entity==null || entity.getId()==0){
			logger.error("添加对象为空或对象处于瞬时态");
			return;
		}
		super.session.save(entity);
		super.transaction.commit();
	}

	@Override
	public void delete(Tag entity) {
		if(entity==null || entity.getId()==0){
			logger.error("添加对象为空或对象处于瞬态");
			return;
		}
		super.session.delete(entity);
		super.transaction.commit();
	}

	@Override
	public List<Tag> getAll(Pagination page) {
		String sql="from Tag";
		Query<Tag> query=super.session.createQuery(sql,Tag.class);
		List<Tag> list=super.toList(query, page);
		return list;
	}

	@Override
	public List<Tag> search(Condition condition, Pagination page) {
		String sql="from Tag where 1=1";
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
		List<Tag> list=super.toList(query, page);
		return list;
	}
	
}

