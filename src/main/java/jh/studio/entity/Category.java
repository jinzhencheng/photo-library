package jh.studio.entity;

import java.util.Set;

public class Category {

	private int id;
	private String name;
	private int sequence;
	private Category parentId;
	private String parentTag;
	private Integer isValid;
	private Set<CategoryAgent> tags;

	public Category(){}
	public Category(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public Set<CategoryAgent> getTags() {
		return tags;
	}
	public void setTags(Set<CategoryAgent> tags) {
		this.tags = tags;
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
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public Category getParentId() {
		return parentId;
	}
	public void setParentId(Category parentId) {
		this.parentId = parentId;
	}
	public String getParentTag() {
		return parentTag;
	}
	public void setParentTag(String parentTag) {
		this.parentTag = parentTag;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	
	
}
