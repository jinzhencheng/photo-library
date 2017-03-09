package jh.studio.dal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jh.studio.inter.GeneralBase;

/**
 * @author jinzhencheng
 * @email jinzhencheng@outlook.com
 * @description: 操作基类
 */
public class BaseDal{

	private GeneralBase base=null;
	protected Transaction transaction=null;
	protected Session session=null;

	public BaseDal(){
		base=new GeneralBase();
		session=base.openSession();
		transaction=session.beginTransaction();
	}
	
	
	public void dispose(){
		if(base==null)
			return;
		base.closeSession();
	}
}
