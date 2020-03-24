package com.briup.demo.utils;

/**
 * 自定义响应的返回数据类型
 * @author Shinelon
 *
 */
public class Message<T> {
	private Integer status; //状态码
	private String message; //返回的数据信息
	
	private T data ; // 返回的数据类
	
	private  Long time ;//返回的时间

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Message(Integer status, String message, T data, Long time) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.time = time;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
