package jh.studio.entity;

import java.util.List;

public class Category {

	private int id;
	private String name;
	private int sequence;
	private Category parentId;
	private List<Tag> tags;

	public Category(){}
	public Category(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
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
	
	
}
