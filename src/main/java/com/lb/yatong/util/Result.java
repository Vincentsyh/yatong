package com.lb.yatong.util;


import org.springframework.stereotype.Component;

/***前端请求返回值封装类
 * code:{
 *     0 : 失败
 *     1 ：成功
 * }
 * @Author: liangbin
 * @Date: 2018/6/26 18:19
 */
@Component
public class Result<T> {

	private int code;
	private T data;
	private String message;

	public int getCode() {
		return code;
	}

	public Result<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public T getData() {
		return data;
	}

	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public Result<T> setMessage(String message) {
		this.message = message;
		return this;
	}
}