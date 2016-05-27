package com.springsource.petclinic.web.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.springsource.petclinic.exceptions.EntityResultNotFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	// THIS IS NOT WORKING. SEEMS LIKE @ControllerAdvice is not
	// checking root cause exception
	/*@ExceptionHandler(EntityResultNotFoundException.class)
	public String handle(MethodArgumentTypeMismatchException ex) {
		return "errors/404";
	}*/
	
	// We should check it manually using getRootCause() method.
	@ExceptionHandler
	public String handle(MethodArgumentTypeMismatchException ex) {
		if(ex.getRootCause() instanceof EntityResultNotFoundException){
			return "errors/404";
		}
		return "errors/500";
	}
	
}
