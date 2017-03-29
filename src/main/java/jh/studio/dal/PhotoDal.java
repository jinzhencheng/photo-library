package jh.studio.dal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;

public class PhotoDal extends BaseDal<Photo> {
	private Logger logger = null;
	
	
	public List<String> getYear(Pagination page)
	{
		List<String> result = new ArrayList<String>();
		String sql="select * from photo order by year desc";
		Query<Photo> query=super.session.createNativeQuery(sql, Photo.class);
		List<Photo> list=super.toList(query, page);
		for(Photo p:list)
		{
			if(!result.contains(p.getYear()))
			{
				result.add(p.getYear());
			}
		}
		return result;
	}
	
	public List<String> getMonth(Pagination page,String year)
	{
		List<String> result = new ArrayList<String>();
		String sql="select * from photo where year="+year+" order by month desc";
		Query<Photo> query=super.session.createNativeQuery(sql, Photo.class);
		List<Photo> list=super.toList(query, page);
		for(Photo p:list)
		{
			if(!result.contains(p.getMonth()))
			{
				result.add(p.getMonth());
			}
		}
		return result;
	}
	
	public List<Photo> getPicture(Pagination page,String year,String month)
	{
		String sql="select * from photo where year="+year+" and month="+month+" order by id desc";
		Query<Photo> query=super.session.createNativeQuery(sql, Photo.class);
		List<Photo> list=super.toList(query, page);
		return list;
	}
	
	public List<Photo> getBigPicture(Pagination page,String minPath)
	{
		String sql="select * from photo where the_minpath="+minPath;
		Query<Photo> query=super.session.createNativeQuery(sql, Photo.class);
		List<Photo> list=super.toList(query, page);
		return list;
	}
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
	public List<Photo> searchByCategory(int categoryId,Pagination page){
		String sql="select * from photo where id in "
				+ "(select photo_id from category_agent as ca left join photo_agent as pa on ca.tag_id = pa.tag_id where ca.category_id =1)";
		Query<Photo> query=super.session.createNativeQuery(sql,Photo.class);
		List<Photo> list=super.toList(query, page);
		return list;
	}
	public Map<String,List<String>>  fetchYearAndMonth(){
		String sql="select year,month from photo group by year,month";
		List<?> list=super.session.createNativeQuery(sql).getResultList();
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		for(Object obj:list){
			String year=Array.get(obj,0).toString();
			String month=Array.get(obj,1).toString();
			if(map.containsKey(year)){
				List<String> months=map.get(year);
				months.add(month);
			}else{
				List<String> months=new ArrayList<String>();
				months.add(month);
				map.put(year,months);
			}
		}
		return map;
	}
}
