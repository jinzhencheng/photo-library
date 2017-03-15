package jh.studio.dal;

import org.apache.log4j.Logger;

import jh.studio.entity.Opinion;

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
}
