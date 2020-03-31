package colt45s.canbanapi.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import colt45s.canbanapi.application.resource.ErrorResponse;
import colt45s.canbanapi.domain.exception.NotFoundException;

/**
 * RestExceptionHandler
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    List<String> details = ex.getBindingResult().getFieldErrors().stream()
        .map(fieldError -> fieldError.getField() + ":" + fieldError.getDefaultMessage()).collect(Collectors.toList());

    ErrorResponse body = new ErrorResponse("Bad Request", details);

    return super.handleExceptionInternal(ex, body, headers, status, request);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Object> handle404(NotFoundException ex, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();
    List<String> details = new ArrayList<>();
    details.add(ex.getLocalizedMessage());
    ErrorResponse body = new ErrorResponse("Not Found", details);
    HttpStatus status = HttpStatus.NOT_FOUND;

    return super.handleExceptionInternal(ex, body, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    Object responseBody = body == null ? new ErrorResponse(ex.getMessage(), ex.getLocalizedMessage()) : body;

    return super.handleExceptionInternal(ex, responseBody, headers, status, request);
  }

}