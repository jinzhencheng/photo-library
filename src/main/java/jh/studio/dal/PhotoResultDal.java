package jh.studio.dal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Pagination;
import jh.studio.entity.PhotoResult;

public class PhotoResultDal extends BaseDal<PhotoResult> {
	public List<PhotoResult> getAll(Pagination page) {
		String sql = "SELECT p.id, p.name,p.the_date,p.the_minpath,GROUP_CONCAT(t.`name`) FROM photo p, photo_agent pa, tag t"
               +" WHERE p.id = pa.`photo_id` AND pa.tag_id=t.id GROUP BY p.id";
		Query query = super.session.createNativeQuery(sql);
		List<PhotoResult> pr = new ArrayList<PhotoResult>();
		List list = super.toList(query, page);
		PhotoResult re = new PhotoResult();
		for (int i = 0; i < list.size(); i++) {
			Object[] o = (Object[]) list.get(i);
			//每个object中有5行数据
			for (int j = 0; j < o.length; j = j + 5) {
				re.setName(o[1].toString());
				re.setMinpath(o[2].toString());
				re.setDate(o[3].toString());
				re.setTagName(o[4].toString());
				pr.add(re);
			}
			o = null;
		}
        return pr;	
	}
}
