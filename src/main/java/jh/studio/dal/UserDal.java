package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;


import jh.studio.entity.Pagination;
import jh.studio.entity.User;

public class UserDal extends BaseDal {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<User> getAll(Pagination page) {

		List<User> list = new ArrayList<User>();
		String sql = "select * from my_user limit "+(page.getPage()-1)+","+page.getRows();
		list=session.createNativeQuery(sql).addEntity(User.class).list();
		
		System.out.println(list.size());
		return list;
	}
}
