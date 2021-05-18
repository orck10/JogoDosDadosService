package com.example.demo.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.dto.ErrorResponse;

import static com.example.demo.utils.CriaHeaders.criaHeaders;

@RestControllerAdvice
public class ErroGenericoHandler extends ResponseEntityExceptionHandler{
	
	HttpHeaders headers = new HttpHeaders();
	
	@ExceptionHandler(ErroGenerico.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> badRequestErroGenericonHandle(Exception ex, WebRequest request){
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), 
				criaHeaders(), 
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> badRequestExcepitonHandle(Exception ex, WebRequest request){
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), 
				criaHeaders(), 
				HttpStatus.BAD_REQUEST);
	}
}
