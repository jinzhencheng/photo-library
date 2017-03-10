package jh.studio.entity;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class Tag {
	private int id;
	private String name;
	private int clickCount;
	private Set<Category> categories=new HashSet<Category>();
	private Set<Photo> photos=new HashSet<Photo>();

	public Tag(){}

	public Tag(String name){
		this.name=name;
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
	public int getClickCount() {
		return clickCount;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	@JSON(serialize=false)
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	@JSON(serialize=false)
	public Set<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
	
}
