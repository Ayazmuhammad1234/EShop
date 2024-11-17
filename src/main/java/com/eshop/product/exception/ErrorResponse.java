package com.eshop.product.exception;

import java.util.Date;

public class ErrorResponse {

	private int statusCode;
	private Date timestamp;
	private String message;
	private String requestedURI;

	public ErrorResponse(int statusCode, Date timestamp, String message, String requestedURI) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.requestedURI = requestedURI;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

}
