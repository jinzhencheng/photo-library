package jh.studio.entity;

import java.util.Date;

public class Opinion {
	private int id;
	private String content;
	private Date theDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTheDate() {
		return theDate;
	}
	public void setTheDate(Date theDate) {
		this.theDate = theDate;
	}
	
	
}
