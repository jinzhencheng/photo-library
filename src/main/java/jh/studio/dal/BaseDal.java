package jh.studio.dal;

import org.hibernate.Session;

/**
 * @author jinzhencheng
 * @email jinzhencheng@outlook.com
 * @description:逻辑层父类(模板方法）
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
	/*将供子类实现的抽象方法解耦至接口中*/
}
