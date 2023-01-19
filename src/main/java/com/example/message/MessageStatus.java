package com.example.message;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MessageStatus {
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private MessageError messageError;
	   
	public MessageStatus(HttpStatus status) {
		super();
		this.timestamp = LocalDateTime.now();   
		this.status = status;
	   }

	public MessageStatus(HttpStatus status, Exception ex) {
		super();
		this.timestamp = LocalDateTime.now();   
		this.status = status;
	    this.message = "Se disparo un error";
	    this.messageError = new MessageError(ex.getCause().toString(),ex);
	   }

	public MessageStatus(HttpStatus status, String message, MessageError messageError) {
		super();
		this.timestamp = LocalDateTime.now();   
		this.status = status;
	       this.message = message;
	       if(messageError==null) {
	    	   this.messageError = new MessageError("No hay errores",null);
	       }else {
	    	   this.messageError = messageError;
	       }
    	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageError getMessageError() {
		return messageError;
	}

	public void setMessageError(MessageError messageError) {
		this.messageError = messageError;
	}
	
}
