package com.pratibhaproject.firstproject;

import com.pratibhaproject.firstproject.model.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleConflict(
      RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(bodyOfResponse);
        return handleExceptionInternal(ex, exceptionResponse,
          new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}