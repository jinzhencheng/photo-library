package jh.studio.dal;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import jh.studio.entity.Record;

public class RecordDal extends BaseDal<Record>{
	
	private Logger logger=null;
	
	public RecordDal(){
		logger=Logger.getLogger(RecordDal.class);
	}

	public List<Record> fetchByUser(int userId){
		String sql="select * from record where user_id="+userId+" order by id limit 5";
		Query<Record> query=session.createNativeQuery(sql,Record.class);
		return query.getResultList();
	}
	
	public void add(Record entity){
		if(entity==null){
			logger.error("插入对象为空");
			return;
		}
		session.save(entity);
		transaction.commit();
	}

}
