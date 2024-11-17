package com.eshop.product.exception;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletResponse;

 

@ControllerAdvice
public class ExceptionController {

	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleResourceNotFound(final NotFoundException exception,
			final HttpServletResponse request) {

		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(new Date());
		error.setRequestedURI(request.getCharacterEncoding());
		return error;
	}
	
}