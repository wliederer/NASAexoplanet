package com.nasa.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NasaExceptionHandler {
	
	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setErrorDetails(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoValidSearchException.class)
	public ResponseEntity<ErrorResponse> handleNoValidSearchException(NoValidSearchException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setErrorDetails(ex.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}

}
