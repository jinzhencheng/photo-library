package jh.studio.entity;

public class User {
	private int id;
	private String openId;
	
	public User(int id,String openId){
		this.id=id;
		this.openId=openId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	
}
