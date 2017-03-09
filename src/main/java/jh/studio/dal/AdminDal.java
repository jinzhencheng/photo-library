package jh.studio.dal;

import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Admin;

public class AdminDal extends BaseDal {

	@SuppressWarnings("rawtypes")
	public boolean isExist(Admin admin) {
		String sql = "from Admin where username='" + admin.getUsername() + "' and password='" + admin.getPassword()
				+ "'";
		Query result = (Query) session.createQuery(sql);
		List list = result.getResultList();
		return list.size()>0;
	}

}
