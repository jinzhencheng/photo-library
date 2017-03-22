package jh.studio.ctl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.PhotoAgentDal;
import jh.studio.dal.RecordDal;
import jh.studio.entity.Pagination;
import jh.studio.entity.Photo;
import jh.studio.entity.Record;

public class TagRecordAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String searchName;
	private List<Photo> result;
	
	public String listPhotoByTagName()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		//String userId = (String)session.getAttribute("userId");
		String userId = "1";
		PhotoAgentDal paDal = new PhotoAgentDal();
		this.result = paDal.getPhotoByTagName(searchName, Pagination.NULL);
		paDal.dispose();
		
		RecordDal rDal = new RecordDal();
		Record r = new Record();
		r.setContent(searchName);
		r.setUserId(Integer.parseInt(userId));
		rDal.add(r);
		rDal.dispose();
		
		return "searchList";
		
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public List<Photo> getResult() {
		return result;
	}

	public void setResult(List<Photo> result) {
		this.result = result;
	}

}
