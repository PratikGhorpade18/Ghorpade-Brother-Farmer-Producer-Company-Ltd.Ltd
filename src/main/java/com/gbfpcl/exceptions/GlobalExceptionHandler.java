package com.gbfpcl.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gbfpcl.payloads.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiresponse= new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiresponse,HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleExpectionNotValid(MethodArgumentNotValidException ex){
		Map<String, String> map= new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String feildName=((FieldError) error).getField();
		String message=error.getDefaultMessage();
		map.put(feildName, message);
		});
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
}
