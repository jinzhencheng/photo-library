package jh.studio.ctl;


import jh.studio.dal.AdminDal;

public class AdminDll {

	public void execute(){
		AdminDal dal=new AdminDal();
		dal.dispose();
	}
}
