package br.com.zupacademy.lucas.casadocodigo.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorValidationForm>> handle(MethodArgumentNotValidException exception) {
		List<ErrorValidationForm> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorValidationForm erro = new ErrorValidationForm(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> handleNotFound(NotFoundException exception){
		StandardError err = new StandardError(exception.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
				
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
}
