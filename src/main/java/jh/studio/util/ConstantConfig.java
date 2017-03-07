package jh.studio.util;


import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * 
 * @author jinzhencheng
 * @email jinzhencheng@outlook.com
 * @description 读取properties配置属性
 */
public class ConstantConfig {

	private static String name=null;
	private static Configuration config = null;
	public static void setProFileName(String name){
		ConstantConfig.name=name;
	}

	public static void clearConfig(){
		if(config==null)return;
		config.clear();
	}

	private static Configuration getConfig(){
		try {
			config = new PropertiesConfiguration(ConstantConfig.name);
		}catch (ConfigurationException e) {
			System.out.println("read config file error");
			e.printStackTrace();
		} 
		return config;
	}

	public static String getString(String key){
		Configuration conf=getConfig();
		if(conf!=null)
			return conf.getString(key);
		throw new NullPointerException("ConstantConfig:Configuration is null");
	}
	
	
	public static int getInt(String key){
		Configuration conf=getConfig();
		if(conf!=null)
			return conf.getInt(key);
		throw new NullPointerException("ConstantConfig:Configuration is null");
	}
	
	public static boolean getBoolean(String key){
		Configuration conf=getConfig();
		if(conf!=null)
			return conf.getBoolean(key);
		throw new NullPointerException("ConstantConfig:Configuration is null");
	} }