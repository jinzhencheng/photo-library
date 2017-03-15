package jh.studio.dal;

import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Pagination;
import jh.studio.entity.PhotoResult;

public class PhotoResultDal extends BaseDal<PhotoResult>{
	public List<PhotoResult> getAll(Pagination page) {
		String sql="select p.name as name,p.the_minpath,p.the_date,t.name as tagName FROM photo_agent pa LEFT JOIN"+
	    " photo AS p ON p.id=pa.photo_id LEFT JOIN tag AS t ON pa.tag_id=t.id";
		Query query=super.session.createNativeQuery(sql);
		List<PhotoResult> list=super.toList(query, page);
		return list;
	}
}
