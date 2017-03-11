package jh.studio.ctl;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.AdminDal;
import jh.studio.entity.Admin;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Admin admin;
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String execute() throws Exception {
		AdminDal dal = new AdminDal();
		boolean find = dal.isExist(admin);
		return find?SUCCESS:ERROR;
	}

	public String showAdmin() {

		AdminDal dal = new AdminDal();
		admin = dal.findAdmin();
		return admin!=null? SUCCESS : ERROR;
	}

}
