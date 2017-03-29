package jh.studio.util;

import java.util.Date;

//将date类型时间 转换为字符串再次做处理 2017-3-18 12：33：44
//转换为 2017 3-18
public class DateToString {
	public static String[] getResult(Date date) {
		String dt = date.toLocaleString();
		String[] split = dt.split(" ");
		String[] yearMonth = split[0].split("-");
		int month = Integer.parseInt(yearMonth[1]);
		String ym = "";
		if (month < 10) {
			ym = yearMonth[0] + " 0" + yearMonth[1];
		}else{
			ym = yearMonth[0] + " " + yearMonth[1];
		}
		String[] result = ym.split(" ");
		return result;
	}
}
