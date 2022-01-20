package com.main.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {

	public HttpStatus notFound() {
		return HttpStatus.NOT_FOUND;
	}
	
	public HttpStatus internalServer() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public HttpStatus notAccept() {
		return HttpStatus.NOT_ACCEPTABLE;
	}
}
