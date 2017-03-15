package jh.studio.entity;

public class CategoryAgent {
	private int id;
	private Tag tagId;
	private Category categoryId;

	public CategoryAgent(){}
	public CategoryAgent(int id,Tag tagId,Category categoryId){
		this.id=id;
		this.tagId=tagId;
		this.categoryId=categoryId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tag getTagId() {
		return tagId;
	}
	public void setTagId(Tag tagId) {
		this.tagId = tagId;
	}
	public Category getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}
	
	

}
