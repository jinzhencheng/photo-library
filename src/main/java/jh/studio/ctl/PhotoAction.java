package jh.studio.ctl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.condition.PhotoCond;
import jh.studio.dal.PhotoAgentDal;
import jh.studio.dal.PhotoDal;
import jh.studio.dal.PhotoResultDal;
import jh.studio.dal.TagDal;
import jh.studio.dal.UserDal;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import jh.studio.entity.PhotoAgent;
import jh.studio.entity.PhotoResult;
import jh.studio.entity.Tag;
import jh.studio.entity.User;
import jh.studio.util.DateToString;
import net.coobird.thumbnailator.Thumbnails;

public class PhotoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;
	private String tags;
	private String pname;
	private int page;
	private int rows;
	private int photo_id;
	private Map<String, Object> results = new HashMap<String, Object>();
	private List<PhotoResult> photore = new ArrayList<PhotoResult>();
	private List<Photo> photos = new ArrayList<Photo>();
	private String year;
	private String month;
	private String minPath;
	private List<String> result = new ArrayList<String>();
	private Photo photo = new Photo();
	

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Map<String, Object> getResults() {
		return results;
	}

	public int getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}

	public List<PhotoResult> getPhotore() {
		return photore;
	}

	public void setPhotore(List<PhotoResult> photore) {
		this.photore = photore;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public String getMinPath() {
		return minPath;
	}

	public void setMinPath(String minPath) {
		this.minPath = minPath;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		PhotoDal pDal = new PhotoDal();
		this.result = pDal.getYear(Pagination.NULL);
		pDal.dispose();
		return "allYear";
	}

	public String getMonth() {
		PhotoDal pDal = new PhotoDal();
		this.result = pDal.getMonth(Pagination.NULL, year);
		pDal.dispose();
		return "month";
	}

	public String getPicture() {
		PhotoDal pDal = new PhotoDal();
		this.photos = pDal.getPicture(Pagination.NULL, year, month);
		pDal.dispose();
		return "picture";
	}

	public String getBigPicture() {
		PhotoDal pDal = new PhotoDal();
		this.photos = pDal.getBigPicture(Pagination.NULL, minPath);
		return "bigPicture";
	}

	public void setResults(Map<String, Object> results) {
		this.results = results;
	}
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

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
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String execute() throws IOException {
		Photo photo=new Photo();
		String timeName = System.currentTimeMillis() + uploadFileName;
		Date date = new Date();
		String[] yearMonth = DateToString.getResult(date);
		photo.setName(pname);
		photo.setTheDate(date);
		photo.setYear(yearMonth[0]);
		photo.setMonth(yearMonth[1]);
		photo.setPath(savePath + "/" +timeName);
		photo.setMinpath(savePath + "/m" +timeName);
		PhotoDal phoDal = new PhotoDal();
		phoDal.savePhoto(photo);
		phoDal.dispose();
		List<PhotoAgent> photoAgents = new ArrayList<PhotoAgent>();
		String[] tg = tags.split("-");
		for (String tagid : tg) {
			PhotoAgent pa = new PhotoAgent();
			pa.setPhotoId(photo.getId());
			pa.setTagId(Integer.parseInt(tagid));
			photoAgents.add(pa);

		}
		PhotoAgentDal paDal = new PhotoAgentDal();
		paDal.batchAdd(photoAgents);
		paDal.dispose();
		  String filePath = getSavePath(); 
	      File myFilePath = new File(filePath); 
	      if (!myFilePath.exists()) { 
	        myFilePath.mkdir(); 
	      } 
		File goalFile = new File(getSavePath(),timeName);
		File minFile = new File(getSavePath(),"m" + timeName);
		FileUtils.copyFile(upload, goalFile);
		Thumbnails.of(goalFile.toString()).size(200, 300).toFile(minFile.toString());

		return SUCCESS;

	}

	public String showPhoto() {
		System.out.println(photo.getName());
		Condition condition=new PhotoCond(photo.getName());
		Pagination pager = new Pagination();
		pager.setPage(page);
		pager.setRows(rows);

		PhotoResultDal dal = new PhotoResultDal();
		photore = dal.search(condition, pager);
		dal.dispose();
		int total = pager.getTotal();
		results.put("rows", photore);
		results.put("total", total);

		return SUCCESS;
	}

	public String delPhoto() {
		List<Integer> inid = new ArrayList<Integer>();
		inid.add(photo_id);
		PhotoAgentDal dal = new PhotoAgentDal();
		dal.batchDel(inid);
		PhotoDal pdal = new PhotoDal();
		pdal.batchDel(inid);
		return "ok";
	}

	public String updatePhoto() {
		List<Integer> inid = new ArrayList<Integer>();
		inid.add(photo_id);
		PhotoAgentDal dal = new PhotoAgentDal();
		dal.batchDel(inid);
		dal.dispose();
		List<PhotoAgent> updateList = new ArrayList<PhotoAgent>();
		String[] tg = tags.split("-");
		for (String td : tg) {
			PhotoAgent upa = new PhotoAgent();
			upa.setPhotoId(photo_id);
			int tid = Integer.parseInt(td);
			upa.setTagId(tid);
			updateList.add(upa);

		}
		PhotoAgentDal pdUpdate = new PhotoAgentDal();
		pdUpdate.batchAdd(updateList);
		dal.dispose();

		return "ok";
	}

}
