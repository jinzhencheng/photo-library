package jh.studio.dal;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import jh.studio.entity.PhotoResult;
import jh.studio.entity.Tag;

public class PhotoDal extends BaseDal<Photo> {
	private Logger logger = null;

	public void savePhoto(Photo photo) {
		if (photo == null) {
			logger.error("添加对象为空");
			return;
		}
		super.session.saveOrUpdate(photo);
		super.transaction.commit();
	}
	public void delete(Photo entity) {
		if(entity==null || entity.getId()==0){
			logger.error("添加对象为空或对象处于瞬态");
			return;
		}
		super.session.delete(entity);
		super.transaction.commit();
	}
	public Photo getOne(int id){
		Photo entity=super.session.get(Photo.class, id);
		return entity;
	}
	public void update(Photo entity) {
		if(entity==null || entity.getId()==0){
			logger.error("添加对象为空或对象处于瞬时态");
			return;
		}
		super.session.save(entity);
		super.transaction.commit();
	}
	public List<PhotoResult> getAll(Pagination page) {
		String sql="select p.name as name,p.the_minpath,p.the_date,t.name as tagName FROM photo_agent pa LEFT JOIN"+
	    " photo AS p ON p.id=pa.photo_id LEFT JOIN tag AS t ON pa.tag_id=t.id";
		Query query=super.session.createNativeQuery(sql);
		List<PhotoResult> list=super.toList(query, page);
		return list;
	}
	public void batchDel(List<Integer> list)
	{
		if(list == null || list.size() == 0)
		{
			return ;
		}
		String sql="delete from photo where id in ("+list.get(0);
		String ids = "";
		for(Integer i:list)
		{
			ids += ","+i;
		}
		sql += ids;
		sql += ")";
		super.session.createNativeQuery(sql).executeUpdate();
		transaction.commit();	
	}


}
