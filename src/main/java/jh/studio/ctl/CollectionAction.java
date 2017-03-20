package jh.studio.ctl;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.CollectionDal;
import jh.studio.entity.Collection;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;

public class CollectionAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer photoId;
	private Integer userId;
	public List<Photo> list;
	
	public String insertCollect()
	{
		Collection c = new Collection();
		c.setPhotoId(photoId);
		c.setUserId(userId);
		CollectionDal cDal = new CollectionDal();
		cDal.add(c);
		cDal.dispose();
		
		return "insert";
	}
	
	public String listByCollect()
	{
		CollectionDal cDal = new CollectionDal();
		this.list = cDal.list(userId, Pagination.NULL);
		cDal.dispose();
		return "list";
	}
	public Integer getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
