package jh.studio.entity;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private int id;
	private String name;
	private String sequence;
	private Category parentId;
	private Set<Tag> tags=new HashSet<Tag>();

	
	public Category(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
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
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public Category getParentId() {
		return parentId;
	}
	public void setParentId(Category parentId) {
		this.parentId = parentId;
	}
	
	
}
