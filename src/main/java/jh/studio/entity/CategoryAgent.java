package jh.studio.entity;

public class CategoryAgent {
	private int id;
	private int tagId;
	private int categoryId;

	public CategoryAgent(){}
	public CategoryAgent(int id,int tagId,int categoryId){
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
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
	

}
