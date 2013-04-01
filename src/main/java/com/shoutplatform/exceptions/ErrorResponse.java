package com.shoutplatform.exceptions;

public class ErrorResponse {
	
	private String className;
	private String exceptionMessage;
	
	public ErrorResponse(){
		
	}
	
	public ErrorResponse(String className, String exceptionMessage){
		this.className = className;
		this.exceptionMessage = exceptionMessage;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	
	
	
	
}
