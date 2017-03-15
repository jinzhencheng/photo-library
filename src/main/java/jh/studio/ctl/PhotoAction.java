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
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.PhotoAgentDal;
import jh.studio.dal.PhotoDal;
import jh.studio.dal.PhotoResultDal;
import jh.studio.dal.UserDal;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import jh.studio.entity.PhotoAgent;
import jh.studio.entity.PhotoResult;
import jh.studio.entity.Tag;
import jh.studio.entity.User;
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
	private List<String> tags;
	// private List<String> tags;
	private int page;
	private int rows;
	private Map<String, Object> results = new HashMap<String, Object>();
	private List<PhotoResult> photore = new ArrayList<PhotoResult>();

	public Map<String, Object> getResults() {
		return results;
	}

	public void setResults(Map<String, Object> results) {
		this.results = results;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
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
		return ServletActionContext.getServletContext().getRealPath("/WEB-INF/" + savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String execute() throws IOException {
		Photo photo = new Photo();
		String timeName = System.currentTimeMillis() + uploadFileName;
		photo.setName(timeName);
		photo.setTheDate(new Date());
		photo.setPath("/WEB-INF/" + savePath + "/" + photo.getName());
		photo.setMinpath("/WEB-INF/" + savePath + "/m" + photo.getName());
		PhotoDal phoDal = new PhotoDal();
		phoDal.savePhoto(photo);
		phoDal.dispose();
		List<PhotoAgent> photoAgents = new ArrayList<PhotoAgent>();
		for (String tagid : tags) {
			Tag t = new Tag();
			t.setId(Integer.parseInt(tagid));
			Photo p = new Photo();
			p.setId(photo.getId());
			PhotoAgent pa = new PhotoAgent();
			pa.setPhoto_id(p);
			pa.setTag_id(t);
			photoAgents.add(pa);

		}
		PhotoAgentDal paDal = new PhotoAgentDal();
		paDal.batchAdd(photoAgents);
		paDal.dispose();
		File goalFile = new File(getSavePath(), timeName);
		File minFile = new File(getSavePath(), "m" + timeName);
		FileUtils.copyFile(upload, goalFile);
		Thumbnails.of(goalFile.toString()).size(200, 300).toFile(minFile.toString());
		return SUCCESS;

	}

	public String showPhoto() {
		Pagination pager = new Pagination();
		pager.setPage(page);
		pager.setRows(rows);

		PhotoResultDal dal = new PhotoResultDal();
		photore = dal.getAll(pager);
		dal.dispose();
		int total = pager.getTotal();
		results.put("rows", photore);
		results.put("total", total);

		return SUCCESS;
	}

	public String deletePhoto(String[] ids) {
		List<Integer> inid = new ArrayList<Integer>();
		for (String id : ids) {
			inid.add(Integer.parseInt(id));

		}
		PhotoAgentDal dal = new PhotoAgentDal();
		dal.batchDel(inid);
		PhotoDal pdal = new PhotoDal();
		pdal.batchDel(inid);

		return "ok";
	}

}
