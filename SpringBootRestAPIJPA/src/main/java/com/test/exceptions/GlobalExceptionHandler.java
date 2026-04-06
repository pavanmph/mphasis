package com.test.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorMessage> employeeNotFoundException(
			EmployeeNotFoundException e, WebRequest request)
	{
		ErrorMessage message = new ErrorMessage();
		
		int code = HttpStatus.BAD_REQUEST.value();
		
		message.setTimeStamp(new Date());
		message.setMessage(e.getMessage());
		message.setUrl(request.getDescription(false));
		message.setStatusCode(code);
		
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value =  Exception.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorMessage> unknowExceptions(
			Exception e, WebRequest request)
	{
		ErrorMessage message = new ErrorMessage();
		int code = HttpStatus.BAD_REQUEST.value();
		
		message.setTimeStamp(new Date());
		message.setMessage(e.getMessage());
		message.setUrl(request.getDescription(false));
		message.setStatusCode(code);
		
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
}
