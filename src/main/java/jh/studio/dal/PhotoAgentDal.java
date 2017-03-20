package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import jh.studio.entity.PhotoAgent;

public class PhotoAgentDal extends BaseDal<PhotoAgent>{
	public void batchAdd(List<PhotoAgent> list){
		for(PhotoAgent agent:list){
			String sql="insert into photo_agent(id,photo_id,tag_id) values("+agent.getId()+","+agent.getPhotoId()+","+agent.getTagId()+")";
			super.session.createNativeQuery(sql).executeUpdate();
		}
		transaction.commit();
	}
	public void batchDel(List<Integer> list)
	{
		if(list == null || list.size() == 0)
		{
			return ;
		}
		String sql="delete from photo_agent where photo_id in ("+list.get(0);
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
	
	public List<Photo> getPhotoByTagName(String tagName,Pagination page)
	{
		String sql = "select p.id as id,p.name as name,p.the_path as path,p.the_minpath as minpath,p.year as year,p.month as month"
				+ " from tag as t,photo as p,photo_agent as pa "
				+ "where t.id=pa.tag_id and p.id=pa.photo_id and t.name like '%"+tagName+"%'"
				+ " order by p.the_date desc";
			Query query = super.session.createNativeQuery(sql);
			List<Photo> pr = new ArrayList<Photo>();
			List list = super.toList(query, page);
			for (int i = 0; i < list.size(); i++) {
				Object[] o = (Object[]) list.get(i);
				//每个object中有5行数据
				Photo p = new Photo();
				p.setId(Integer.parseInt(o[0].toString()));
				p.setName(o[1].toString());
				p.setPath(o[2].toString());
				p.setMinpath(o[3].toString());
				p.setYear(o[4].toString());
				p.setMonth(o[5].toString());
				pr.add(p);
			}
	        return pr;	
	}
}
