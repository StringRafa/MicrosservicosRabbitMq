package com.microsservice.productapi.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<?> handleValidationException(ValidationException validateException){
		var details = new ExceptionDetails();
		details.setStatus(HttpStatus.BAD_REQUEST.value());
		details.setMessage(validateException.getMessage());
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
	
}
