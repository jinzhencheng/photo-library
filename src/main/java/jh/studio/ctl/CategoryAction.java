package jh.studio.ctl;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.CategoryDal;
import jh.studio.entity.Category;
import jh.studio.entity.Pagination;

public class CategoryAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private List<Category> categories=null;

	public String fetchAll(){
		CategoryDal dal=new CategoryDal();
		this.categories=dal.getAll(Pagination.NULL);
		dal.dispose();
		return "fetchAll";
	}
	
	public List<Category> getCategories(){
		return this.categories;
	}

}
