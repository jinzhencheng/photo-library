package jh.studio.ctl;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.AdminDal;
import jh.studio.entity.Admin;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String result;
	private String newPass;
	private Admin admin;

	public String execute() throws Exception {
		AdminDal dal = new AdminDal();
		boolean find = dal.isExist(admin);
		if (find) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			ServletActionContext.getRequest().getSession().setMaxInactiveInterval(300);
			session.put("admin", admin);
			dal.dispose();
			return SUCCESS;
		}
		return ERROR;
	}

	public String showAdmin() {
		AdminDal dal = new AdminDal();
		admin = dal.findAdmin();
		dal.dispose();
		admin.setPassword("已保护");
		return admin != null ? SUCCESS : ERROR;
	}

	public String updateAdmin() {
		AdminDal dal = new AdminDal();
		boolean flag = dal.isValid(admin);
		if (flag) {
			admin.setPassword(newPass);
			dal.updateAdmin(admin);
			admin.setPassword("已保护");
			result="ok";
			return SUCCESS;
		}
		dal.dispose();
		result="failure";
		return ERROR;
	}

	public void setNewPass(String pass) {
		this.newPass = pass;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}

	public String getResult() {
		return result;
	}

	
}
