package com.javaweb.controlleradvice;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.CustomExceptions.FieldRequiredException;
import com.javaweb.model.ErrorResponseDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	 @ExceptionHandler(ArithmeticException.class)
	    public ResponseEntity<Object> handleArithmeticException(
	            ArithmeticException ex, WebRequest request) {
		 	ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		 	errorResponseDTO.setError(ex.getMessage());
		 	ArrayList<String> details = new ArrayList();
		 	details.add("Khong co so nao chia het cho 0");
		 	errorResponseDTO.setDetal(details);
	        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 @ExceptionHandler(FieldRequiredException.class)
	    public ResponseEntity<Object> handleFieldRequiredException(
	            FieldRequiredException ex, WebRequest request) {
		 	ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		 	errorResponseDTO.setError(ex.getMessage());
		 	ArrayList<String> details = new ArrayList();
		 	details.add("Check lai name hoac basement");
		 	errorResponseDTO.setDetal(details);
	        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
	    }
}
