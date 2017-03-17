package jh.studio.dal;

import java.util.List;

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
}
