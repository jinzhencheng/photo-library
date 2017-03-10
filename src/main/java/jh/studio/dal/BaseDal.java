package jh.studio.dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jh.studio.entity.Pagination;
import jh.studio.inter.GeneralBase;

/**
 * @author jinzhencheng
 * @email jinzhencheng@outlook.com
 * @description: 操作基类
 */
public class BaseDal<T>{

	private GeneralBase base=null;
	protected Transaction transaction=null;
	protected Session session=null;

	public BaseDal(){
		base=new GeneralBase();
		session=base.openSession();
		transaction=session.beginTransaction();
	}
	
	public List<T> toList(Query<T> query,Pagination page){
		int pageSize=page.getRows();
		int pageIndex=page.getPage();
		List<T> list=query
				.setFirstResult((pageIndex - 1) * pageSize)
				.setMaxResults(pageSize)
				.getResultList();
		return list;
	}
	
	public void dispose(){
		if(base==null)
			return;
		base.closeSession();
	}
}
