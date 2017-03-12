package jh.studio.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.UserDal;
import jh.studio.entity.Pagination;
import jh.studio.entity.User;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int page;
	private int rows;
	private List<User> users = new ArrayList<User>();
	private Map<String, Object> results = new HashMap<String, Object>();

	public Map<String, Object> getResults() {
		return results;
	}

	public List<User> getUsers() {
		return users;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String execute() {
		Pagination pager = new Pagination();
		pager.setPage(page);
		pager.setRows(rows);
		UserDal dal = new UserDal();
		users = dal.getAll(pager);

		dal.dispose();
		int total = pager.getTotal();
		results.put("rows", users);
		results.put("total", total);
		return SUCCESS;
	}

	public void addUser() {
		String id = "erf5467";
		UserDal dal = new UserDal();
		if (dal.addUser(id)) {
			System.out.println("ok");
		}
	}
}
