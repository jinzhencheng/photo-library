package jh.studio.dal;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Opinion;
import jh.studio.entity.Pagination;

public class OpinionDal extends BaseDal<Opinion>{

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
}
