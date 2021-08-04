package by.exposit.web.exceptions;

import by.exposit.core.exceptions.EntityAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex,
      WebRequest request) {

    return handleExceptionInternal(ex, buildErrorResponseBody("Not found", ex.getMessage()),
        new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

  @ExceptionHandler(EntityAlreadyExistsException.class)
  protected ResponseEntity<Object> handleEntityCannotBeAdded(
      EntityAlreadyExistsException ex, WebRequest request) {

    return handleExceptionInternal(ex, buildErrorResponseBody("Cannot be added or updated", ex.getMessage()),
        new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {

    return handleExceptionInternal(ex, buildErrorResponseBody("Validation error",
        ex.getBindingResult().getFieldError().getDefaultMessage()),
        new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  private Map<String, String> buildErrorResponseBody(String errorTitle, String message) {
    Map<String, String> map = new HashMap<>();
    map.put("error", errorTitle);
    map.put("message", message);

    return map;
  }
}
