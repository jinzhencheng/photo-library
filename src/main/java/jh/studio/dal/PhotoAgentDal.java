package jh.studio.dal;

import java.util.List;

import jh.studio.entity.PhotoAgent;

public class PhotoAgentDal extends BaseDal<PhotoAgent>{
	public void batchAdd(List<PhotoAgent> list){
		for(PhotoAgent agent:list){
			String sql="insert into photo_agent(id,photo_id,tag_id) values("+agent.getId()+","+agent.getPhoto_id().getId()+","+agent.getTag_id().getId()+")";
			super.session.createNativeQuery(sql).executeUpdate();
		}
		transaction.commit();
	}
}
