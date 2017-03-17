package jh.studio.entity;

public class PhotoAgent {

	private int id;
	private int tagId;
	private int photoId;

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

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public PhotoAgent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhotoAgent(int id, int tagId, int photoId) {
		super();
		this.id = id;
		this.tagId = tagId;
		this.photoId = photoId;
	}

}
