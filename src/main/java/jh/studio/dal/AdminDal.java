package jh.studio.dal;

import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Admin;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.inter.IDal;

public class AdminDal extends BaseDal {

	public boolean isExist(Admin admin) {
		String sql = "from Admin where password=" + admin.getPassword();
		System.out.println(admin.getPassword());
		Query result = (Query) session.createQuery(sql);
		admin =(Admin) result.uniqueResult();
		return (admin!=null);
		
	}

}
