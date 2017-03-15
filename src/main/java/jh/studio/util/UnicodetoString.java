package jh.studio.util;
//%u5173%u4E8E%u6211%u4EEC%u6A21%u5757%u7684%u64CD%u4F5C12de
public class UnicodetoString {
	public static String unicode2String(String unicode) {
		 
	    StringBuffer string = new StringBuffer();
	 
	    String[] hex = unicode.split("\\\\u");
	 
	    for (int i = 1; i < hex.length; i++) {
	 
	        // 转换出每一个代码点
	        int data = Integer.parseInt(hex[i], 16);
	 
	        // 追加成string
	        string.append((char) data);
	    }
	 
	    return string.toString();
	}
}
