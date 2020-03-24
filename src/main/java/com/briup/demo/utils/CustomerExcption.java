package com.briup.demo.utils;
/**
 * 自定义异常
 * @author Shinelon
 *
 */
public class CustomerExcption extends RuntimeException {

	/**
	 * 序列化号
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer code; //状态吗

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public CustomerExcption(Integer code,String message) {
		super(message);
		this.code = code;
	}
	
	
	

}
