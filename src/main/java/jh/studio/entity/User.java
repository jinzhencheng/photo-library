package jh.studio.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;
	private String openId;
	private Set<Photo> photos=new HashSet<Photo>();

	public User(int id,String openId){
		this.id=id;
		this.openId=openId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
	
}
