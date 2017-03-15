package jh.studio.ctl;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.OpinionDal;
import jh.studio.entity.Opinion;

public class OpinionAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private String content;
	private String result;

	public String add(){
		Date date=new Date();
		Opinion entity=new Opinion();
		entity.setContent(content);
		entity.setTheDate(date);
		OpinionDal dal=new OpinionDal();
		dal.add(entity);
		dal.dispose();
		result="finished";
		return SUCCESS;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResult(){
		return result;
	}
	
}
