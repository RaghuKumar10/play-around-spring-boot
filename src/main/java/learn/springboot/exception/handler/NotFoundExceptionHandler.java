package learn.springboot.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import learn.springboot.exception.RecordsNotFoundException;
import learn.springboot.exception.ResourceNotFoundException;
import learn.springboot.exception.entity.ErrorDescription;

@RestControllerAdvice
public class NotFoundExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDescription resourceNotFoundHandler(ResourceNotFoundException ex) {
		return new ErrorDescription(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	
	@ExceptionHandler(RecordsNotFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ErrorDescription recordsNotFoundHandler(RecordsNotFoundException ex) {
		return new ErrorDescription(HttpStatus.NO_CONTENT.value(), ex.getMessage());
	}
}
