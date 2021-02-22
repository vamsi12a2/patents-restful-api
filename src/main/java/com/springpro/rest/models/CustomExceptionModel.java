package com.springpro.rest.models;

public class CustomExceptionModel {
	
	String timestamp;
	
	String message;
	
	String details;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public CustomExceptionModel(String timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public CustomExceptionModel() {
		// TODO Auto-generated constructor stub
	}
	

}
