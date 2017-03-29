package jh.studio.ctl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.condition.CategoryCond;
import jh.studio.dal.CategoryAgentDal;
import jh.studio.dal.CategoryDal;
import jh.studio.dal.TagDal;
import jh.studio.entity.Category;
import jh.studio.entity.CategoryAgent;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;

public class CategoryAction extends ActionSupport{
	private Logger logger= Logger.getLogger(CategoryDal.class);
	private static final long serialVersionUID = 1L;
	private List<Category> categories=null;
	private int page;
	private int rows;
	private Map<String,Object> resultMap;
	private Category category = new Category();
	private int categoryId;
	private String tagIds;
	private String categoryName;
	private int categorySequence;
	private String categoryParentId;
	private File uploadMin;
	private String uploadMinFileName;
	private String uploadMinContentType;
	private String savePath;

	public String fetchAll(){
		CategoryDal dal=new CategoryDal();
		this.categories=dal.getAll(Pagination.NULL);
		dal.dispose();
		return "fetchAll";
	}
	
	public String uploadFile()
	{
		try
		{
			String timeName = System.currentTimeMillis() + uploadMinFileName;
			String filePath = getSavePath(); 
		    File myFilePath = new File(filePath); 
		    if (!myFilePath.exists()) {
		    	myFilePath.mkdir();
		    }
		    File minFile = new File(getSavePath(),"m" + timeName);
		    FileUtils.copyFile(uploadMin, minFile);
		    return savePath + "/m" + timeName;
		}
		catch(Exception e)
		{
			logger.debug(e);
			return null;
		}
	}
	public String list(){
		Condition condition=new CategoryCond(category.getName()); 
		Pagination pager=new Pagination();
		pager.setPage(page);
		pager.setRows(rows);

		CategoryDal cgDal=new CategoryDal();
		List<Category> tags=cgDal.search(condition, pager);
		cgDal.dispose();

		int total=pager.getTotal();
		resultMap=new HashMap<String,Object>();
		resultMap.put("rows",tags);
		resultMap.put("total",total);
		return "list";
	}

	public String fetchOne()
	{
		CategoryDal categoryDal=new CategoryDal();
		this.category=categoryDal.getOne(category.getId());
		categoryDal.dispose();
		return "fetchOne";
	}
	
	public String fetchOneLevel()
	{
		CategoryDal categoryDal=new CategoryDal();
		this.categories=categoryDal.getOneLevelCategory(Pagination.NULL);
		Category e = new Category();
		e.setId(-1);
		e.setName("未选择");
		categories.add(0,e);
		categoryDal.dispose();
		return "fetchOneLevel";
	}
	
	public void delCategory()
	{
		CategoryDal dal = new CategoryDal();
		Category t = dal.getOne(categoryId);
		if(t == null)
		{
			dal.dispose();
		}
		else
		{
			t.setIsValid(0);
			dal.update(t);
			dal.dispose();
		}
	}
	public String getCategoryByParentId()
		{
			CategoryDal dal=new CategoryDal();
			this.categories = dal.getCategoryList(categoryId);
			return "categoryListByParentId";
		}
	public void save(){
		CategoryDal dal=new CategoryDal();
		Category t = dal.getOne(categoryId);
		if(t != null)
		{
			Category tt = new Category();
			tt.setId(categoryId);
			tt.setName(categoryName);
			tt.setSequence(categorySequence);
			if(!StringUtils.isBlank(uploadMinFileName) && uploadMin != null)
			{
				String path = uploadFile();
				tt.setMinPicture(path);
			}
			if(!categoryParentId.equals("未选择"))
			{
				tt.setParentId(Integer.parseInt(categoryParentId));
			}
			dal.updateCategory(tt);
			dal.dispose();
			
			//数据库中，原先的分类集合
			Set<CategoryAgent> set = t.getTags();
			List<CategoryAgent> insertList = new ArrayList<CategoryAgent>();
			List<Integer> delList = new ArrayList<Integer>();
			
			for(CategoryAgent c:set)
			{
				String tempTagId = "-"+tagIds+"-";
				String id = "-"+c.getTagId().getId()+"-";
				if(c.getCategoryId().getId() == categoryId && !tempTagId.contains(id))
				{
					delList.add(c.getTagId().getId());
				}
			}
			
			String ids = "-";
			for(CategoryAgent c:set)
			{
				ids += c.getTagId().getId()+"-";
			}
			String[] tagIdArray = tagIds.split("-");
			for(String c:tagIdArray)
			{
				if(!ids.contains("-"+c+"-"))
				{
					CategoryAgent ca = new CategoryAgent();
					
					Tag t1 = new Tag();
					t1.setId(Integer.parseInt(c));
					
					Category cg = new Category();
					cg.setId(categoryId);
					
					ca.setCategoryId(cg);
					ca.setTagId(t1);
					
					insertList.add(ca);
				}
			}
			
			CategoryAgentDal cgAgentDal = new CategoryAgentDal();
			cgAgentDal.batchDelByCategory(delList,categoryId);
			cgAgentDal.batchAdd(insertList);
			cgAgentDal.dispose();
		}
		else
		{
			try
			{
				Set<CategoryAgent> tagSet = new HashSet<CategoryAgent>();
				TagDal tDal = new TagDal();
				List<Tag> tagList = tDal.getTag(tagIds);
				if(tagList == null)
				{
					tagList = new ArrayList<Tag>();
				}
				tDal.dispose();
				
				Category category = new Category();
				category.setId(categoryId);
				category.setName(categoryName);
				category.setSequence(categorySequence);
				category.setIsValid(1);//有效
				if(!categoryParentId.equals("未选择"))
				{
					category.setParentId(Integer.parseInt(categoryParentId));
				}
				
				for(Tag c:tagList)
				{
					CategoryAgent ca = new CategoryAgent();
					ca.setCategoryId(category);
					ca.setTagId(c);
					tagSet.add(ca);
				}
				category.setTags(tagSet);
				String path = uploadFile();
				category.setMinPicture(path);
				dal.add(category);
				dal.dispose();
			}catch(Exception e)
			{
				logger.debug(e);
			}
		}
	}
	
	public String fetchParentCategory(){
		CategoryDal dal=new CategoryDal();
		this.categories=dal.getOneLevelCategory(Pagination.NULL);
		dal.dispose();
		ServletActionContext.getRequest().setAttribute("categories", categories);
		return "fetchParentCategory";
	}
	public String fetchCategoryByParent(){
		CategoryDal dal=new CategoryDal();
		this.categories = dal.getCategoryList(categoryId);
		dal.dispose();
		ServletActionContext.getRequest().setAttribute("categories", categories);
		return "fetchCategoryByParent";
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

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	} 
	public List<Category> getCategories(){
		return this.categories;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getTagIds() {
		return tagIds;
	}


	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public int getCategorySequence() {
		return categorySequence;
	}


	public void setCategorySequence(int categorySequence) {
		this.categorySequence = categorySequence;
	}


	public String getCategoryParentId() {
		return categoryParentId;
	}


	public void setCategoryParentId(String categoryParentId) {
		this.categoryParentId = categoryParentId;
	}


	public File getUploadMin() {
		return uploadMin;
	}


	public void setUploadMin(File uploadMin) {
		this.uploadMin = uploadMin;
	}


	public String getUploadMinFileName() {
		return uploadMinFileName;
	}


	public void setUploadMinFileName(String uploadMinFileName) {
		this.uploadMinFileName = uploadMinFileName;
	}


	public String getUploadMinContentType() {
		return uploadMinContentType;
	}


	public void setUploadMinContentType(String uploadMinContentType) {
		this.uploadMinContentType = uploadMinContentType;
	}


	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


}
