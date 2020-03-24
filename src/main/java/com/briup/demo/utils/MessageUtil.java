package com.briup.demo.utils;

import java.util.Date;

/**
 * 返回消息的工具类
 * 
 * @author Shinelon
 *
 */
public class MessageUtil {
	
	/**
	 * 三种情况
	 * 1.成功且返回数据
	 * 2.成功不返回数据
	 * 3.失败
	 */
	public static <E>Message<E> success(E obj){  //1.成功且返回数据
		
		return  new Message<E>(200, "success", obj, new Date().getTime());
		
	}
	
	public static <E>Message<E> success(){  //2.成功不返回数据
		
		
		//return  new Message<E>(200, "success", null, new Date().getTime());
		return MessageUtil.success(null);
		
	}
	
	public static <E>Message<E> error(Integer code,String msg){  //3.失败,将自定义异常返回
		
		//MessageUtil.success(null);
		return  new Message<E>(code, msg, null, new Date().getTime());
		//return null;
		
	}

}
