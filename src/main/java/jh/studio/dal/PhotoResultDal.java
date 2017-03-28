package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.PhotoResult;
import jh.studio.inter.IDal;

public class PhotoResultDal extends BaseDal<PhotoResult> implements IDal<PhotoResult> {
	@Override
	public void add(PhotoResult entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PhotoResult entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PhotoResult entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PhotoResult> search(Condition condition, Pagination page) {
		String sql ="";
		if(null != condition && null!=condition.getName()){
			sql+="SELECT p.id, p.name,p.the_date,p.the_minpath,p.year,p.month,GROUP_CONCAT(t.`name`),p.the_path FROM photo p, photo_agent pa, tag t"
		               +" WHERE p.id = pa.`photo_id` AND pa.tag_id=t.id";
			sql+=" and p.name like '%"+condition.getName()+"%' GROUP BY p.id desc";
		}else{
			sql="SELECT p.id, p.name,p.the_date,p.the_minpath,p.year,p.month,GROUP_CONCAT(t.`name`),p.the_path FROM photo p, photo_agent pa, tag t"
		               +" WHERE p.id = pa.`photo_id` AND pa.tag_id=t.id GROUP BY p.id desc";
		}
			Query query = super.session.createNativeQuery(sql);
			List<PhotoResult> pr = new ArrayList<PhotoResult>();
			List list = super.toList(query, page);
			for (int i = 0; i < list.size(); i++) {
				Object[] o = (Object[]) list.get(i);
				//每个object中有5行数据
				PhotoResult re = new PhotoResult();
					re.setId(Integer.parseInt(o[0].toString()));
					re.setName(o[1].toString());
					re.setDate(o[2].toString());
					re.setMinpath(o[3].toString());
					re.setYear(o[4].toString());
					re.setMonth(o[5].toString());
					re.setTagName(o[6].toString());
					re.setPath(o[7].toString());
					pr.add(re);
				
			}
	        return pr;		
	}

	@Override
	public void saveOrUpdate(PhotoResult entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PhotoResult> getAll(Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}
}
