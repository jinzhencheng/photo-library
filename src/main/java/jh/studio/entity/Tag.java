package jh.studio.entity;

import java.util.Set;

public class Tag {
	private int id;
	private String name;
	private int clickCount;
	private String parentCategories;
	private Integer isValid;
	private Set<CategoryAgent> categoryIds;
	private Set<PhotoAgent> photo;

	public Tag(){}
	public Tag(String name){
		this.name=name;
	}
	public String getParentCategories() {
		return parentCategories;
	}
	public void setParentCategories(String parentCategories) {
		this.parentCategories = parentCategories;
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
	public Set<CategoryAgent> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(Set<CategoryAgent> categoryIds) {
		this.categoryIds = categoryIds;
	}
	public Set<PhotoAgent> getPhoto() {
		return photo;
	}
	public void setPhoto(Set<PhotoAgent> photo) {
		this.photo = photo;

	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;

	}
	
}
