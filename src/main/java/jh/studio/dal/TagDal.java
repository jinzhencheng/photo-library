package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.CategoryAgent;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;
import jh.studio.inter.IDal;

public class TagDal extends BaseDal<Tag> implements IDal<Tag>{

	private Logger logger=null;

	public TagDal(){
		logger=Logger.getLogger(TagDal.class);
	}

	public Tag getOne(int id){
		Tag entity=super.session.get(Tag.class, id);
		return entity;
	}


	private void loadCategory(Tag entity){
		Set<CategoryAgent> categories=entity.getCategoryIds();
		StringBuilder builder=new StringBuilder();
		for(CategoryAgent c:categories){
			builder.append(c.getCategoryId().getName()+" ");
		}
		entity.setParentCategories(builder.toString());
	}
	
	public List<Tag> getHot(){
		//TODO:查询热门标签语句
		String sql="";
		Query<Tag> query=super.session.createNativeQuery(sql,Tag.class);
		super.transaction.commit();
		return query.getResultList();
	}

	@Override
	public void saveOrUpdate(Tag entity){
		if(entity==null){
			logger.error("添加对象为空");
			return;
		}
		super.session.saveOrUpdate(entity);
		super.transaction.commit();
	}

	@Override
	public void add(Tag entity){
		if(entity==null){
			logger.error("添加对象为空");
			return;
		}
		super.session.save(entity);
		super.transaction.commit();
	}

	@Override
	public void update(Tag entity) {
		if(entity==null || entity.getId()==0){
			logger.error("添加对象为空或对象处于瞬时态");
			return;
		}
		super.session.update(entity);
		super.transaction.commit();
	}

	@Override
	public void delete(Tag entity) {
		if(entity==null || entity.getId()==0){
			logger.error("添加对象为空或对象处于瞬态");
			return;
		}
		super.session.delete(entity);
		super.transaction.commit();
	}

	@Override
	public List<Tag> getAll(Pagination page) {
		String sql="select * from tag where isValid=1";
		Query<Tag> query=super.session.createNativeQuery(sql, Tag.class);
		List<Tag> list=super.toList(query, page);
		return list;
	}

	@Override
	public List<Tag> search(Condition condition, Pagination page) {
		String sql="select * from tag where isValid=1 ";
		if(null!=condition.getName()){
			sql+="and name like '%"+condition.getName()+"%'";
		}
		sql+=" order by id desc";
		Query<Tag> query=super.session.createNativeQuery(sql, Tag.class);
		List<Tag> list=super.toList(query, page);
		for(Tag t:list){
			loadCategory(t);
		}
		
		return list;
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
	public List<Tag> getTag(String tagIds)
	{
		List<Integer> idList = translate(tagIds);
		if(idList == null)
		{
			return null;
		}
		String sql="select * from tag where isValid=1 and id in("+idList.get(0);
		for(Integer id:idList)
		{
			sql+=","+id;
		}
		sql+=")";
		Query<Tag> query=super.session.createNativeQuery(sql, Tag.class);
		List<Tag> list=query.getResultList();
		return list;
	}
	
}
