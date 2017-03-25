package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Collection;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;

public class CollectionDal extends BaseDal<Collection> {
	private Logger logger=null;
	public CollectionDal(){
		logger=Logger.getLogger(CategoryDal.class);
	}
	
	public void add(Collection entity) {
		if(entity==null){
			logger.error("添加对象为空");
			return;
		}
		super.session.save(entity);
		super.transaction.commit();
	}

	public void batchDel(String ids[],int userId){
		String sql="delete from collection where user_id="+userId+" and photo_id in (";
		for(int i=0;i<ids.length;++i){
			sql+=ids[i];
			if(i!=ids.length-1){
				sql+=",";
			}
		}
		sql+=")";
		super.session.createNativeQuery(sql).executeUpdate();
		super.transaction.commit();
	}	

	public List<Photo> list(Integer userId,Pagination page){
		String sql = "SELECT p.id,p.name,p.the_path,p.the_minpath,p.year,p.month"
				+ " FROM photo p, collection c"
	               +" WHERE p.id = c.photo_id and c.user_id="+userId;
			Query query = super.session.createNativeQuery(sql);
			List<Photo> pr = new ArrayList<Photo>();
			List list = super.toList(query, page);
			for (int i = 0; i < list.size(); i++) {
				Object[] o = (Object[]) list.get(i);
				//每个object中有5行数据
				Photo re = new Photo();
					re.setId(Integer.parseInt(o[0].toString()));
					re.setName(o[1].toString());
					re.setPath(o[2].toString());
					re.setMinpath(o[3].toString());
					re.setYear(o[4].toString());
					re.setMonth(o[5].toString());
					pr.add(re);
				
			}
	        return pr;	
	}
	
	public void delCollection(Integer photoId,Integer userId)
	{
		String sql="delete from collection where photo_id="+photoId+" and user_id="+userId;
		super.session.createNativeQuery(sql).executeUpdate();
	}
}
