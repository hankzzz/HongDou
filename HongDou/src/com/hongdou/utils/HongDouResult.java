package com.hongdou.utils;

/**
@Description: 用于向前台返回格式化的数据
 */
public class HongDouResult {
	//用于显示请求的状态true：成功/false：失败
	private boolean status;
	//用于包装需要向前台传送的数据
	private Object object;
	//请求的信息
	private String message;
	
	
	public boolean isStatus() {
		return status;
	}
	public boolean getStatus(){
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HongDouResult [status=" + status + ", object=" + object + ", message=" + message + "]";
	}
	
	
}
