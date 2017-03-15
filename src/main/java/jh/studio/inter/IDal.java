package jh.studio.inter;

import java.util.List;

import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;

/**
 * @author jinzhencheng
 * @email jinzhencheng@outlook.com
 * @description: 基础操作接口
 */
public interface IDal<T> {
	
	abstract void add(T entity);
	abstract void update(T entity);
	abstract void delete(T entity);
	abstract List<T> getAll(Pagination page);
	abstract List<T> search(Condition condition,Pagination page);
	abstract void saveOrUpdate(T entity);
	

}
