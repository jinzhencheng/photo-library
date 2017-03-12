package jh.studio.dal;

import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Admin;

public class AdminDal extends BaseDal {

	@SuppressWarnings("rawtypes")
	public boolean isExist(Admin admin) {
		String sql = "select * from admin where username='" + admin.getUsername() + "' and password='" + admin.getPassword()
				+ "'";
		Query result = (Query) session.createNativeQuery(sql);
		List list = result.getResultList();
		System.out.println(list.size()+"................");
		return list.size()>0;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Admin findAdmin(){
		Admin admin=new Admin();
		String sql ="from Admin";
		Query result = (Query) session.createQuery(sql);
		List<Admin> list = result.getResultList();
		admin=list.get(0);
		return admin;
	}
	
	public int updateAdmin(Admin admin){
	    String sql="update admin set username='"+admin.getUsername()+"'"+",password='"+admin.getPassword()+"'"+" where id="+admin.getId();	
	    if(session.createNativeQuery(sql).executeUpdate() > 0){
	    	super.transaction.commit();
	    	
	    	return 1;
	    }
			return 0;
	}

}
