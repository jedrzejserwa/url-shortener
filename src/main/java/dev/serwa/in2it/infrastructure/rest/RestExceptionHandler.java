package dev.serwa.in2it.infrastructure.rest;

import dev.serwa.in2it.url.shortener.dto.UrlNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(UrlNotFoundException.class)
  ResponseEntity<RestErrorMessage> urlNotFoundRestHandler(UrlNotFoundException exception) {
    return new ResponseEntity<>(new RestErrorMessage(exception), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  ResponseEntity<RestErrorMessage> validationRestHandler(IllegalArgumentException exception) {
    return new ResponseEntity<>(new RestErrorMessage(exception), HttpStatus.BAD_REQUEST);
  }
}