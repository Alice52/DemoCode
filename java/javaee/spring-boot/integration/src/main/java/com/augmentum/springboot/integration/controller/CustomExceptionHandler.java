package com.augmentum.springboot.integration.controller;

import com.augmentum.springboot.integration.constants.HttpConstants;
import com.augmentum.springboot.integration.exception.UserNotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zack
 * @create 2019-12-25 22:40
 * @function base exception handler, if extends by others controller, will return 200.
 */
@ControllerAdvice
public class CustomExceptionHandler {
  private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

  @ExceptionHandler(UserNotExistException.class)
  public HttpServletRequest handleUserNotExistException(
      UserNotExistException e, HttpServletRequest request) {
    Map<String, Object> map = new HashMap<>();

    map.put("code", "runtime error");
    map.put("message", e);

    request.setAttribute(HttpConstants.EXT, map);
    request.setAttribute(HttpConstants.SERVER_CODE, 405);

    return request;
  }

  @ExceptionHandler(Exception.class)
  public String handleException(Exception e, HttpServletRequest request) {
    Map<String, Object> map = new HashMap<>();
    request.setAttribute(HttpConstants.JAVAX_SERVLET_ERROR_STATUS_CODE, 500);
    map.put("code", "9999");
    map.put("message", "system exception");

    request.setAttribute("ext", map);
    return "forward:/error";
  }
}
