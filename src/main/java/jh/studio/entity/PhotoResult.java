package jh.studio.entity;

import java.util.Date;
import java.util.List;

public class PhotoResult {
	private int id;
	private String name;
	private String date;
	private String minpath;
	private String tagName;
    private String year;
    private String month;
    
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public PhotoResult() {
		super();
		// TODO Auto-generated constructor stub
	}

}
