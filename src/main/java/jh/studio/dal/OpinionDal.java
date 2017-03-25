package jh.studio.dal;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Condition;
import jh.studio.entity.Opinion;
import jh.studio.entity.Pagination;
import jh.studio.inter.IDal;

public class OpinionDal extends BaseDal<Opinion> implements IDal<Opinion>{

	private Logger logger=null;

	public OpinionDal(){
		logger=Logger.getLogger(TagDal.class);
	}
	
	public void add(Opinion entity){
		if(entity==null){
			logger.error("对象为空");
			return;
		}
		super.session.save(entity);
		super.transaction.commit();
	}
	public List<Opinion> getAll(Pagination page){
		String sql="select * from opinion";
		Query<Opinion> query=session.createNativeQuery(sql,Opinion.class);
		List<Opinion> list = super.toList(query, page);
		return list;
	}
	@Override
	public List<Opinion> search(Condition condition, Pagination page) {
		String sql="select * from opinion";
		if(null != condition && null!=condition.getName()){
			sql+=" where content like '%"+condition.getName()+"%'";
		}
		sql+=" order by the_date desc";
		Query<Opinion> query=super.session.createNativeQuery(sql, Opinion.class);
		List<Opinion> list=super.toList(query, page);
		return list;
		
	}

	@Override
	public void saveOrUpdate(Opinion entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Opinion entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Opinion entity) {
		// TODO Auto-generated method stub
		
	}
}
