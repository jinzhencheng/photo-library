package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;
import jh.studio.entity.User;
public class UserDal extends BaseDal<User> {
	public List<User> getAll(Pagination page) {

		List<User> list = new ArrayList<User>();
		String sql="from User";
		Query<User> query=super.session.createQuery(sql,User.class);
		list=super.toList(query, page);
		return list;
	}
	
	public boolean addUser(String id) {
		String sql = "insert into my_user(id,open_id) values(0,'" + id + "')";
		if (session.createNativeQuery(sql).executeUpdate() > 0) {
			super.session.getTransaction().commit();
			return true;
		}
		return false;

	}
}
