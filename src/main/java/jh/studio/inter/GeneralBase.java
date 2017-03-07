package jh.studio.inter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * @author jinzhencheng
 * @email jinzhencheng@outlook.com
 * @description hibernate»ù´¡Àà
 */
public class GeneralBase {
	
	private Configuration conf=null;
	private SessionFactory factory=null;
	private Session session=null;

	public GeneralBase(){
		conf=new Configuration().configure();
		factory=conf.buildSessionFactory();
	}
	
	/*ÀÁººµ¥Àý*/
	public Session openSession(){
		if(session!=null)
			return session;
		if(factory!=null){
			session=factory.openSession();
		}
		return session;
	}
	
	public void closeSession(){
		if(session!=null)
			session.close();
	}
	
}
