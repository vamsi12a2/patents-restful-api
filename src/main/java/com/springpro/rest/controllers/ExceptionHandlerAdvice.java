package com.springpro.rest.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springpro.rest.exceptions.PatentNotFoundException;
import com.springpro.rest.models.CustomExceptionModel;

@ControllerAdvice
public class ExceptionHandlerAdvice{
	
	@ExceptionHandler(PatentNotFoundException.class)
	public ResponseEntity<CustomExceptionModel> handlePatentNotFoundException(PatentNotFoundException ex, WebRequest request){
		CustomExceptionModel exception=new CustomExceptionModel(new Date().toString(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<CustomExceptionModel> handleAuthenticationException(AuthenticationException ex, WebRequest request){
		CustomExceptionModel exception=new CustomExceptionModel(new Date().toString(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<CustomExceptionModel> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request){
		CustomExceptionModel exception=new CustomExceptionModel(new Date().toString(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<CustomExceptionModel> handleRuntimeException(RuntimeException ex, WebRequest request){
		CustomExceptionModel exception=new CustomExceptionModel(new Date().toString(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exception,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}