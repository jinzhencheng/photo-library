package jh.studio.dal;

import java.util.List;

import org.hibernate.query.Query;

import jh.studio.entity.Setting;

public class SettingDal extends BaseDal<Setting>{

	public Setting findInfo(int flag){
		String sql="from Setting where flag="+flag;
		Query<Setting> query=session.createQuery(sql,Setting.class);
		Setting setting=query.getSingleResult();
		return setting;
	}

	public void updateInfo(Setting setting) {
		session.saveOrUpdate(setting);
		transaction.commit();
	}
	
	public List<Setting> findAll(){
		String hql="from Setting";
		Query<Setting> query=session.createQuery(hql,Setting.class);
		List<Setting> list=query.getResultList();
		return list;
	}
}
