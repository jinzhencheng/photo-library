package jh.studio.dal;

import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Setting;

public class StatementDal extends BaseDal<Setting>{

	public Setting findInfo(){
		Setting setting=new Setting();
		String sql="from Setting where flag=2";
		Query<Setting> query=session.createQuery(sql,Setting.class);
		List<Setting> list=query.getResultList();
		setting=list.get(0);
		return setting;
	}
	public int updateInfo(Setting setting) {
		String sql = "update setting set content='"+setting.getContent()+"' where id="+setting.getId();
		if (session.createNativeQuery(sql).executeUpdate() > 0) {
			super.transaction.commit();

			return 1;
		}
		return 0;
	}
	
}
