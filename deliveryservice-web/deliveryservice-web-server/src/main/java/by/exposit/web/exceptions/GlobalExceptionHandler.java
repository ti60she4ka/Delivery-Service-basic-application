package by.exposit.web.exceptions;

import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.exceptions.RepeatingEntityException;
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

  @ExceptionHandler(RepeatingEntityException.class)
  protected ResponseEntity<Object> handleRepeatingEntity(RepeatingEntityException ex,
      WebRequest request) {

    return handleExceptionInternal(ex,
        buildErrorResponseBody("Entity has duplicate", ex.getMessage()),
        new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  @ExceptionHandler(EntityCannotBeAddedException.class)
  protected ResponseEntity<Object> handleEntityCannotBeAdded(
      EntityCannotBeAddedException ex, WebRequest request) {

    return handleExceptionInternal(ex, buildErrorResponseBody("Cannot be added", ex.getMessage()),
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
