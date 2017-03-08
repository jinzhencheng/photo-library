package jh.studio.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Photo {
	
	private int id;
	private String name;
	private Date theDate;
	private Set<Tag> tags=new HashSet<Tag>();
	private Set<User> users=new HashSet<User>();

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
	
	
}
