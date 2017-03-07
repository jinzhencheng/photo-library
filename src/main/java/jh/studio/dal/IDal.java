package jh.studio.dal;

import java.util.List;

import jh.studio.entity.Condition;
import jh.studio.entity.Pagination;

/**
 * @author jinzhencheng
 * @email jinzhencheng@outlook.com
 * @description: Âß¼­²ã½Ó¿Ú
 */
public interface IDal<T> {
	
	abstract int add(T t);
	abstract int update(T t);
	abstract int delete(T t);
	abstract List<T> search(Condition condition,Pagination page);

}
