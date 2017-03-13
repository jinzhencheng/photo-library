package jh.studio.ctl;


import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.SettingDal;
import jh.studio.entity.Setting;
import jh.studio.util.UnicodetoString;

public class SetInfoAction extends ActionSupport {
	private Setting setting;
	private String result;
	private static final long serialVersionUID = 1L;
	public String findInfo() {
		SettingDal setDal = new SettingDal();
		setting = setDal.findInfo();
		setDal.dispose();
		return setting!=null?SUCCESS:ERROR;
	}
	public String updateInfo() throws UnsupportedEncodingException{
		SettingDal setdal=new SettingDal();
		String oldContent=setting.getContent();
		String newContent=java.net.URLDecoder.decode(oldContent,"utf-8");   
		setting.setContent(newContent);
		int n;
		n=setdal.updateInfo(setting);
		if(n==1){
			result="ok";
			return SUCCESS;
		}
		setdal.dispose();
		result="failure";
		return ERROR;
	
	}
	public Setting getSetting() {
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	

	

}
