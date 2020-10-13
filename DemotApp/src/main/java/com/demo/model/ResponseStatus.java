package com.demo.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseStatus {
	
	private int code;
	private String message;
	
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	 

}
