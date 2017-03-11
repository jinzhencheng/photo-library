package jh.studio.ctl;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.AdminDal;
import jh.studio.entity.Admin;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	Admin admin = new Admin();

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public String execute() throws Exception {
		AdminDal dal = new AdminDal();
		boolean find = dal.isExist(admin);
		if (find)
			return SUCCESS;
		return ERROR;

	}

	public String showAdmin() {

		AdminDal dal = new AdminDal();
		admin = dal.findAdmin();
		return admin!=null? SUCCESS : ERROR;
	}

}
