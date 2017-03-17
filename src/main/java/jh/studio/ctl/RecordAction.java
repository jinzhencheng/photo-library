package jh.studio.ctl;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.RecordDal;
import jh.studio.entity.Record;

public class RecordAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private int userId;
	private List<Record> list=new ArrayList<Record>();
	
	public String fetchRecord(){
		RecordDal dal=new RecordDal();
		list=dal.fetchByUser(userId);
		dal.dispose();
		return SUCCESS;
	}
	
	
	public List<Record> getList() {
		return list;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
