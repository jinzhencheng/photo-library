package jh.studio.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Photo {

	private int id;
	private String name;
	private Date theDate;
	private Set<Tag> tags = new HashSet<Tag>();
	private Set<User> users = new HashSet<User>();
	private String path;
	private String minpath;
	private String year;
	private String month;
	private Set<PhotoAgent> tag;

	public Photo(int id, String name, Set<User> users, String path) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.path = path;
	}

	public Photo() {
		super();
	}
	
	public String getMinpath() {
		return minpath;
	}

	public void setMinpath(String minpath) {
		this.minpath = minpath;
	}

	public String getPath() {
		return path;
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

	public void setPath(String path) {
		this.path = path;
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

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<PhotoAgent> getTag() {
		return tag;
	}

	public void setTag(Set<PhotoAgent> tag) {
		this.tag = tag;
	}


}
