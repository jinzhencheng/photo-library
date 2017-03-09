package jh.studio.util;

import org.apache.log4j.Logger;

public class NullObjectException extends Exception{

	/**
	 * 自定义异常
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger=null;
	public NullObjectException(){
		super();
		 logger=Logger.getLogger(NullObjectException.class); 
	}

	public NullObjectException(String message){
		logger.error("-------发生错误：-------\n"+ message);
	}
}
