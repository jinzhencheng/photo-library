package jh.studio.ctl;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import jh.studio.dal.AdminDal;
import jh.studio.entity.Admin;
//查询后连接未关闭
public class AdminDll {
	public static void main(String[] args) {
		Admin admin = new Admin(1, "cheryl", "123");
		AdminDal dal = new AdminDal();
		boolean find = dal.isExist(admin);
		System.out.println(find);
		dal.dispose();
	}
}
