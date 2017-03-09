package jh.studio.dal;

import org.hibernate.Session;

import jh.studio.inter.GeneralBase;

/**
 * @author jinzhencheng
 * @email jinzhencheng@outlook.com
 * @description: 操作基类
 */
public class BaseDal{

	private GeneralBase base=null;
	protected Session session=null;

	public BaseDal(){
		base=new GeneralBase();
		session=base.openSession();
	}
	
	public void dispose(){
		if(base==null)
			return;
		base.closeSession();
	}
	/*��������ʵ�ֵĳ��󷽷��������ӿ���*/
}
