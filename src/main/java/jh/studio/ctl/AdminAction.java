package jh.studio.ctl;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.AdminDal;
import jh.studio.entity.Admin;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String newPass;
	private Admin admin;

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
	
	public String updateAdmin(){
		AdminDal dal = new AdminDal();
		return dal.updateAdmin(admin)>0?SUCCESS:ERROR;
	}

	public void setNewPass(String pass){
		this.newPass=pass;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Admin getAdmin() {
		return admin;
	}
}
