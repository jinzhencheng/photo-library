package jh.studio.ctl;


import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.SettingDal;
import jh.studio.entity.Setting;
import java.net.URLDecoder;

public class SetInfoAction extends ActionSupport {
	private Setting setting;
	private String result;
	private int flag;

	private static final long serialVersionUID = 1L;

	public String findInfo() {
		SettingDal setDal = new SettingDal();
		setting = setDal.findInfo(flag);
		setDal.dispose();
		return setting!=null?"findInfo-success":"findInfo-eror";
	}

	public String updateInfo() throws UnsupportedEncodingException{

		String oldContent=setting.getContent();
		String newContent=URLDecoder.decode(oldContent,"utf-8");   
		setting.setContent(newContent);

		SettingDal setdal=new SettingDal();
		setdal.updateInfo(setting);
		setdal.dispose();

		result="ok";
		return "updateInfo-success";
	}

	
	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getResult() {
		return result;
	}

	public Setting getSetting() {
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}
	

}
