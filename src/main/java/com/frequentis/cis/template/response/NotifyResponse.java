package com.frequentis.cis.template.response;

public class NotifyResponse {
	
	private String status;
	private String message;
	private String origError;
	
	public NotifyResponse() {
		
	}
	
	public NotifyResponse(String status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public NotifyResponse(String status, String message, String origError) {
		this.status = status;
		this.message = message;
		this.origError = origError;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrigError() {
		return origError;
	}

	public void setOrigError(String origError) {
		this.origError = origError;
	}

}
