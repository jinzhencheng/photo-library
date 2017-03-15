package jh.studio.dal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Pagination;
import jh.studio.entity.PhotoResult;

public class PhotoResultDal extends BaseDal<PhotoResult>{
	public List<PhotoResult> getAll(Pagination page) {
		String sql="select p.name as name,p.the_minpath,p.the_date,t.name as tagName FROM photo_agent pa LEFT JOIN"+
	    " photo AS p ON p.id=pa.photo_id LEFT JOIN tag AS t ON pa.tag_id=t.id";
		Query query=super.session.createNativeQuery(sql);
		List<PhotoResult> pl=new ArrayList();
		List list=super.toList(query, page);
		for(int i=0;i<list.size();i++){
			Object[] o=(Object[]) list.get(i);
			for(int j=0;j<o.length;j++){
				PhotoResult re=new PhotoResult();
				re.setName(o[0].toString());
				re.setMinpath(o[1].toString());
				re.setDate(o[2].toString());
				re.setTagName(o[3].toString());
				pl.add(re);
			}
		}
		return pl;
	}
}
