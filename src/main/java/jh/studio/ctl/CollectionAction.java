package jh.studio.ctl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

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
	private Integer userId=1;
	private List<Photo> list=null;
	private String photoIds;
	private int pageIndex=1;
	
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
		Pagination page=new Pagination();
		page.setPage(pageIndex);
		CollectionDal cDal = new CollectionDal();
		this.list = cDal.list(userId,page);
		cDal.dispose();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		return "listByCollect";
	}
	
	public String delCollect()
	{
		CollectionDal cDal = new CollectionDal();
		cDal.delCollection(photoId, userId);
		cDal.dispose();
		return "del";
	}
	public String delCollectList(){
		String[] photoIdArray=photoIds.split("-");
		CollectionDal dal=new CollectionDal();
		dal.batchDel(photoIdArray,userId);
		dal.dispose();
		return listByCollect();
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
	public List<Photo> getList(){
		return list;
	}
	public void setPhotoIds(String photoIds){
		this.photoIds=photoIds;
	}
	public void setPageIndex(int pageIndex){
		this.pageIndex=pageIndex;
	}
}
