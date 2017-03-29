package jh.studio.entity;

import java.util.Set;

public class Category {

	private int id;
	private String name;
	private Integer sequence;
	private Integer parentId;
	private String parentTag;
	private Integer isValid;
	private Set<CategoryAgent> tags;
	private String parentName;
	private String minPicture;
	public Category(){}
	public Category(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public String getMinPicture() {
		return minPicture;
	}
	public void setMinPicture(String minPicture) {
		this.minPicture = minPicture;
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
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
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
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getMinPicture() {
		return minPicture;
	}
	public void setMinPicture(String minPicture) {
		this.minPicture = minPicture;
	}
	
}
