package com.nasa.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private Integer errorCode;
	private String errorDetails;
	private HttpStatus status;
	private LocalDateTime timestamp;

}
