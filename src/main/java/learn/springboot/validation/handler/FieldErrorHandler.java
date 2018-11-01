package learn.springboot.validation.handler;

import java.util.List;
import java.util.Locale;
import static java.util.stream.Collectors.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import learn.springboot.validation.entity.CustomFieldError;
import learn.springboot.validation.entity.ValidationDescrption;

@RestControllerAdvice
public class FieldErrorHandler {
	
	private MessageSource messageSource;
	
	@Autowired
	public FieldErrorHandler(MessageSource messageSource){
		this.messageSource = messageSource;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationDescrption processFieldValiation(MethodArgumentNotValidException ex) {
		return processFieldErrors(ex.getBindingResult().getFieldErrors());
	}

	private ValidationDescrption processFieldErrors(List<FieldError> fieldErrors) {
		ValidationDescrption description = new ValidationDescrption();
		
		description.setFieldErrors(fieldErrors.stream()
				.map(this::resolveLocalizedErrorMessage)
				.collect(toList()));
		
		return description;
	}
	
	private CustomFieldError resolveLocalizedErrorMessage(FieldError fieldError) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
		if (localizedErrorMessage == null || localizedErrorMessage.isEmpty()) {
			String[] fieldErrorCodes = fieldError.getCodes();
			localizedErrorMessage = fieldErrorCodes[0];
		}

		return new CustomFieldError(fieldError.getField(), localizedErrorMessage);
	}
	
}
