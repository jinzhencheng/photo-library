package jh.studio.dal;

import org.apache.log4j.Logger;

import jh.studio.entity.Photo;

public class PhotoDal extends BaseDal<Photo>{
	private Logger logger=null;
	public void savePhoto(Photo photo){
		if(photo==null){
			logger.error("添加对象为空");
			return;
		}
		super.session.saveOrUpdate(photo);
		super.transaction.commit();
	}
}


