package jh.studio.ctl;

import java.util.HashMap;

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
		dal.dispose();
		return find?SUCCESS:ERROR;
	}

	public String showAdmin() {
		AdminDal dal = new AdminDal();
		admin = dal.findAdmin();
		admin.setPassword("已保护");
		dal.dispose();
		return admin!=null? SUCCESS : ERROR;
	}
	
	public String updateAdmin(){
		AdminDal dal = new AdminDal();
		int okNumber=0;
		boolean flag=dal.isExist(admin);
		System.out.println(flag+"............");
		if(flag){
			admin.setPassword(newPass);
			okNumber=dal.updateAdmin(admin);
			admin.setPassword("已保护");
			dal.dispose();
			return SUCCESS;
		}
		admin.setUsername("reject");
		dal.dispose();
		return ERROR;
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
