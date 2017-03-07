package jh.studio.entity;

import java.util.Date;

public class Photo {
	
	private int id;
	private String name;
	private Date theDate;
	
	public Photo(int id,String name,Date theDate){
		this.id=id;
		this.name=name;
		this.theDate=theDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTheDate() {
		return theDate;
	}

	public void setTheDate(Date theDate) {
		this.theDate = theDate;
	}
	
}
