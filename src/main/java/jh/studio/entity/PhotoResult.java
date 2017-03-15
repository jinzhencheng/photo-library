package jh.studio.entity;

import java.util.Date;

public class PhotoResult {
	private String name;
	private Date data;
	private String minpath;
	private String tagName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMinpath() {
		return minpath;
	}

	public void setMinpath(String minpath) {
		this.minpath = minpath;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public PhotoResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
