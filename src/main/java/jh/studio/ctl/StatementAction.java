package jh.studio.ctl;

import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;

import jh.studio.dal.StatementDal;
import jh.studio.entity.Setting;

public class StatementAction extends ActionSupport {
	private Setting setting;
	private String result;
	private static final long serialVersionUID = 1L;

	public String findStatement() {
		StatementDal setDal = new StatementDal();
		setting = setDal.findInfo();
		setDal.dispose();
		return setting != null ? SUCCESS : ERROR;
	}

	public String updateStatement() throws UnsupportedEncodingException {
		StatementDal setDal = new StatementDal();
		String oldContent = setting.getContent();
		String newContent = java.net.URLDecoder.decode(oldContent, "utf-8");
		setting.setContent(newContent);
		int n;
		n = setDal.updateInfo(setting);
		if (n == 1) {
			result = "ok";
			return SUCCESS;
		}
		setDal.dispose();
		result = "failure";
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
