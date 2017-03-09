package jh.studio.ctl;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.AdminDal;
import jh.studio.entity.Admin;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		AdminDal dal = new AdminDal();
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		boolean find = dal.isExist(admin);
		if (find)
			return "SUCCESS";
		return "ERROR";

	}

}
