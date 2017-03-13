package jh.studio.entity;

import java.util.List;

public class Tag {
	private int id;
	private String name;
	private int clickCount;
	private String parentCategories;
	private List<Integer> categoryIds;

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
	public List<Integer> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}
	
}
