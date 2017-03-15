package jh.studio.dal;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.query.Query;

import jh.studio.entity.Category;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
import jh.studio.entity.Tag;
import jh.studio.inter.IDal;

public class CategoryDal extends BaseDal<Category> implements IDal<Category>{

	@Override
	public void add(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> getAll(Pagination page) {
		String sql="from Category";
		Query<Category> query=super.session.createQuery(sql,Category.class);
		List<Category> list=super.toList(query, page);
		return list;
	}

	@Override
	public List<Category> search(Condition condition, Pagination page) {
		// TODO Auto-generated method stub
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
