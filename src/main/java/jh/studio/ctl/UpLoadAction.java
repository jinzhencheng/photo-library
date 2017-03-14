package jh.studio.ctl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.PhotoDal;
import jh.studio.entity.Photo;

public class UpLoadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;
	//private List<String> tags;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath("/WEB-INF/"+savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String execute() throws IOException{
		 		Photo photo=new Photo();
		 		photo.setName(System.currentTimeMillis()+uploadFileName);	
		 		photo.setTheDate(new Date());
		 		photo.setPath("/WEB-INF/"+savePath+photo.getName());
		 		
		 		PhotoDal phoDal=new PhotoDal();
		 		phoDal.savePhoto(photo);
		 		phoDal.dispose();
		 		File goalFile=new File(getSavePath(),getUploadFileName());
		 		FileUtils.copyFile(upload, goalFile);
		 		return SUCCESS;
		 		
		 	}
    
}
