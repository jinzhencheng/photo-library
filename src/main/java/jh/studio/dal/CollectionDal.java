package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Collection;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import jh.studio.entity.PhotoResult;
import jh.studio.inter.IDal;

public class CollectionDal extends BaseDal<Collection> implements IDal<Collection>{
	private Logger logger=null;
	public CollectionDal(){
		logger=Logger.getLogger(CategoryDal.class);
	}
	
	@Override
	public void add(Collection entity) {
		if(entity==null){
			logger.error("添加对象为空");
			return;
		}
		super.session.save(entity);
		super.transaction.commit();
	}
	@Override
	public void update(Collection entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Collection entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Collection> getAll(Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Collection> search(Condition condition, Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void saveOrUpdate(Collection entity) {
		// TODO Auto-generated method stub
		
	}
	public List<Photo> list(Integer userId,Pagination page)
	{
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
}
