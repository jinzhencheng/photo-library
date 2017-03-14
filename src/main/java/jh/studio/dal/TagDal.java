package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Category;
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

	private List<Category> getCategories(Tag entity){
		String sql="select * from category_agent as agent left join category as cate "
				+ "on agent.category_id=cate.id where agent.tag_id="+entity.getId();
		Query<Category> query=super.session.createNativeQuery(sql,Category.class);
		return query.getResultList();
	}

	private void loadCategory(Tag entity){
		List<Category> categories=getCategories(entity);
		List<Integer> categoryIds=new ArrayList<Integer>();
		StringBuilder builder=new StringBuilder();
		for(Category c:categories){
			builder.append(c.getName()+" ");
			categoryIds.add(c.getId());
		}
		entity.setParentCategories(builder.toString());
		entity.setCategoryIds(categoryIds);
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
		super.session.save(entity);
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
		String sql="from Tag";
		Query<Tag> query=super.session.createQuery(sql,Tag.class);
		List<Tag> list=super.toList(query, page);
		return list;
	}

	@Override
	public List<Tag> search(Condition condition, Pagination page) {
		String sql="select * from tag where 1=1 ";
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
	
}

