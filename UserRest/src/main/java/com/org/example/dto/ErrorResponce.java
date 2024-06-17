package com.org.example.dto;

import java.time.LocalDate;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

public class ErrorResponce {
 
	private  String Msg;
	private String errorDetails;
	private LocalDate timestamp;
	
	public ErrorResponce() {
		super();
	}

	public ErrorResponce(String msg, String errorDetails) {
		super();
		Msg = msg;
		this.errorDetails = errorDetails;
		this.timestamp = timestamp.now();
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorResponce [Msg=" + Msg + ", errorDetails=" + errorDetails + ", timestamp=" + timestamp + "]";
	}
 
}
