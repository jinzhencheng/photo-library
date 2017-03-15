package jh.studio.entity;

public class PhotoAgent {
	private int id;
	private Tag tag_id;
	private Photo photo_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tag getTag_id() {
		return tag_id;
	}
	public void setTag_id(Tag tag_id) {
		this.tag_id = tag_id;
	}
	public Photo getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(Photo photo_id) {
		this.photo_id = photo_id;
	}
	public PhotoAgent(int id, Tag tag_id, Photo photo_id) {
		super();
		this.id = id;
		this.tag_id = tag_id;
		this.photo_id = photo_id;
	}
	public PhotoAgent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
	
	

	