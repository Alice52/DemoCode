package cn.edu.ntu.javaee.springboot.validation.handler;

import cn.edu.ntu.javaee.springboot.validation.common.ErrorMessageEnum;
import cn.edu.ntu.javaee.springboot.validation.common.ErrorResponse;
import cn.edu.ntu.javaee.springboot.validation.exception.ListValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * There are 4 types exceptions.
 *
 * <pre>@ControllerAdvice should be added basePackages for performance.
 * @author zack <br>
 * @create 2020-07-28 22:19 <br>
 * @project validation <br>
 */
@ControllerAdvice // basePackages = "cn.edu.ntu.jsr303.controller"
@ResponseBody
public class BeanValidationExceptionHandler {

  protected static ResponseEntity buildResponseEntity(
      ErrorResponse errorResponse, HttpStatus status) {
    return new ResponseEntity<>(errorResponse, status);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity handleException(Exception ex) {

    ErrorResponse errorResponse = ErrorResponse.error(ErrorMessageEnum.SYSTEM_ERROR);

    return buildResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity handleValidationException(ValidationException ex) {

    Throwable cause = ex.getCause();
    Map<String, Object> collect = new HashMap<>(16);

    if (cause instanceof ListValidException) {
      Map<Integer, Set<ConstraintViolation<Object>>> errors =
          ((ListValidException) cause).getErrors();

      errors.forEach(
          (i, error) -> {
            error.stream()
                .forEach(
                    x -> {
                      String path = x.getPropertyPath().toString();
                      Map<String, Object> map = new HashMap<>(4);
                      map.put("rejectValue", x.getInvalidValue());
                      map.put("message", x.getMessage());
                      collect.put("[" + i + "]." + path, map);
                    });
          });
    } else {

    }

    ErrorResponse errorResponse = ErrorResponse.error(ErrorMessageEnum.BEAN_VALIDATION_ERROR);
    errorResponse.setParameters(collect);

    return buildResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity handleBindException(BindException ex) {

    Map<String, Object> collect =
        ex.getBindingResult().getFieldErrors().stream()
            .collect(
                Collectors.toMap(
                    FieldError::getField,
                    x -> {
                      Map<String, Object> map = new HashMap<>(2);
                      map.put("rejectValue", x.getRejectedValue());
                      map.put("message", x.getDefaultMessage());

                      return map;
                    }));

    ErrorResponse errorResponse = ErrorResponse.error(ErrorMessageEnum.BEAN_VALIDATION_ERROR);
    errorResponse.setParameters(collect);

    return buildResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
  }

  @ResponseBody
  @ExceptionHandler(ConstraintViolationException.class)
  public Object handleConstraintViolationException(ConstraintViolationException ex) {

    ErrorResponse errorResponse = ErrorResponse.error(ErrorMessageEnum.BEAN_VALIDATION_ERROR);
    Map<String, Object> collect =
        ex.getConstraintViolations().stream()
            .collect(
                Collectors.toMap(
                    x -> {
                      String path = x.getPropertyPath().toString();
                      int index = path.indexOf(".");
                      return path.substring(index + 1);
                    },
                    x -> {
                      Map<String, Object> map = new HashMap<>(4);
                      map.put("rejectValue", x.getInvalidValue());
                      map.put("message", x.getMessage());

                      return map;
                    }));

    errorResponse.setParameters(collect);

    return buildResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
  }

  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

    Map<String, Object> collect =
        ex.getBindingResult().getFieldErrors().stream()
            .collect(
                Collectors.toMap(
                    FieldError::getField,
                    x -> {
                      Map<String, Object> map = new HashMap<>(2);
                      map.put("rejectValue", x.getRejectedValue());
                      map.put("message", x.getDefaultMessage());

                      return map;
                    }));

    ErrorResponse errorResponse = ErrorResponse.error(ErrorMessageEnum.BEAN_VALIDATION_ERROR);
    errorResponse.setParameters(collect);

    return buildResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
