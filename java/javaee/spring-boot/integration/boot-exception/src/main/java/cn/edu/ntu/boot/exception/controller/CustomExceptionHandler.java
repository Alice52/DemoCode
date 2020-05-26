package cn.edu.ntu.boot.exception.controller;

import cn.edu.ntu.boot.exception.exception.UserNotExistException;
import cn.edu.ntu.javaee.boot.common.constants.HttpConstants;
import cn.edu.ntu.javaee.boot.common.response.ErrorMessageEnum;
import cn.edu.ntu.javaee.boot.common.response.ErrorResponse;
import cn.hutool.core.map.MapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
    Map<String, Object> map = new HashMap<>(4);

    map.put("code", "runtime error");
    map.put("message", e);

    request.setAttribute(HttpConstants.EXT, map);
    request.setAttribute(HttpConstants.SERVER_CODE, 405);

    return request;
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseBody
  public ErrorResponse handleRuntimeException(RuntimeException e, HttpServletRequest request) {

    ErrorResponse errorResponse = ErrorResponse.error(ErrorMessageEnum.UNKNOWN_EXCEPTION);
    errorResponse.setParameters(MapUtil.of("Cause", e.getCause()));

    return errorResponse;
  }

  /**
   * <code>ResponseEntity</code> is status and (T) body, so we can put our response to body, and
   * specify http status code.
   *
   * @param e
   * @param request
   * @return <code>ResponseEntity</code> , and response body is <code>ErrorResponse</code>
   */
  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity handleRuntimeException2(RuntimeException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;

    ErrorResponse errorResponse = ErrorResponse.error(ErrorMessageEnum.UNKNOWN_EXCEPTION);
    errorResponse.setParameters(MapUtil.of("Cause", e.getCause()));

    return new ResponseEntity<>(errorResponse, status);
  }

  @ExceptionHandler(Exception.class)
  public String handleException(Exception e, HttpServletRequest request) {
    Map<String, Object> map = new HashMap<>(16);
    request.setAttribute(HttpConstants.JAVAX_SERVLET_ERROR_STATUS_CODE, 500);
    map.put("code", "9999");
    map.put("message", "system exception");

    request.setAttribute("ext", map);
    return "forward:/error";
  }
}
