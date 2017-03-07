package jh.studio.dal;

import java.util.List;

import jh.studio.entity.Admin;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.inter.IDal;

public class AdminDal extends BaseDal implements IDal<Admin>{

	public int add(Admin t) {
		//session.save(arg0)
		return 0;
	}

	@Override
	public int update(Admin t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Admin t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Admin> search(Condition condition, Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}

}
