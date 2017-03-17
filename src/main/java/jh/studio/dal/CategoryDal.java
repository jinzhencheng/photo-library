package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Category;
import jh.studio.entity.CategoryAgent;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;
import jh.studio.inter.IDal;

public class CategoryDal extends BaseDal<Category> implements IDal<Category>{
	private Logger logger=null;
	public CategoryDal(){
		logger=Logger.getLogger(CategoryDal.class);
	}
	
	@Override
	public void add(Category entity) {
		if(entity==null){

			logger.error("添加对象为空");
			return;
		}
		super.session.save(entity);
		super.transaction.commit();
	}

	@Override
	public void update(Category entity) {
		if(entity==null || entity.getId()==0){
			logger.error("添加对象为空或对象处于瞬时态");
			return;
		}
		super.session.update(entity);
		super.transaction.commit();
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		
	}
	public Category getOne(int id){
		Category entity=super.session.get(Category.class, id);
		return entity;
	}
	
	public void updateCategory(Category entity)
	{
		String sql="update category set name='"+entity.getName()+"',sequence="+entity.getSequence()+",parent_id="+entity.getParentId()+" where id="+entity.getId();
		super.session.createNativeQuery(sql).executeUpdate();
	}
	public List<Category> getOneLevelCategory(Pagination page)
	{
		String sql="select * from category where isValid=1 and id=parent_id";
		Query<Category> query=super.session.createNativeQuery(sql, Category.class);
		List<Category> list=super.toList(query, page);
		return list;
	}
	@Override
	public List<Category> getAll(Pagination page) {
		String sql="select * from category where isValid=1";
		Query<Category> query=super.session.createNativeQuery(sql, Category.class);
		List<Category> list=super.toList(query, page);
		return list;
	}
	private void loadTag(Category entity){
		Set<CategoryAgent> categories=entity.getTags();
		StringBuilder builder=new StringBuilder();
		for(CategoryAgent c:categories){
			builder.append(c.getTagId().getName()+" ");
		}
		entity.setParentTag(builder.toString());
	}
	@Override
	public List<Category> search(Condition condition, Pagination page) {
		String sql="select * from category where isValid=1";
		if(null != condition && null!=condition.getName()){
			sql+=" and name like '%"+condition.getName()+"%'";
		}
		sql+=" order by sequence desc";
		Query<Category> query=super.session.createNativeQuery(sql, Category.class);
		List<Category> list=super.toList(query, page);
		for(Category t:list){
			loadTag(t);
			t.setParentName(findParentList(list,t));
		}
		
		return list;
	}
	
	String findParentList(List<Category> list ,Category t)
	{
		for(Category c:list)
		{
			if(t.getParentId() != null && t.getParentId().equals(c.getId()))
			{
				return c.getName();
			}
		}
		return null;
	}
	@Override
	public void saveOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		
	}
	private List<Integer> translate(String categoryIds){
		List<Integer> cateIdList=new ArrayList<Integer>();
		if(StringUtils.isNotEmpty(categoryIds)){
			String cateIdAry[]=categoryIds.split("-");
			for(String id:cateIdAry){
				cateIdList.add(Integer.valueOf(id));
			}
		}
		return cateIdList;

	}
	public List<Category> getCategory(String categoryIds)
	{
		List<Integer> idList = translate(categoryIds);
		if(idList == null)
		{
			return null;
		}
		String sql="select * from category where isValid=1 and id in("+idList.get(0);
		for(Integer id:idList)
		{
			sql+=","+id;
		}
		sql+=")";
		Query<Category> query=super.session.createNativeQuery(sql, Category.class);
		List<Category> list=query.getResultList();
		return list;
	}
}
