package br.com.zup.casadocodigo.exceptions;


import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourcesNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err =  new StandardError();
		
		err.setTimestamp(LocalDateTime.now());
		err.setStatus(status.value());
		err.setError("Recurso não Encontrado!");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
			
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		 
		StandardError err =  new StandardError();
		
		err.setTimestamp(LocalDateTime.now());
		err.setStatus(status.value());
		err.setError("Database exception");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
			
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		
		ValidationError err =  new ValidationError();
		
		err.setTimestamp(LocalDateTime.now());
		err.setStatus(status.value());
		err.setError("Erro de Validação");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		for (FieldError f: e.getBindingResult().getFieldErrors()) {
			
			err.addError(f.getField(), f.getDefaultMessage());
			
		}
		
		return ResponseEntity.status(status).body(err);
			
	}
	

}
