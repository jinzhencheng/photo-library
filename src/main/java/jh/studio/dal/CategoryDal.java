package jh.studio.dal;

import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Category;
import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;
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
}
