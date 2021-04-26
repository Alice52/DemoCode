package cn.edu.ntu.boot.exception.controller;

import cn.edu.ntu.boot.exception.exception.UserNotExistException;
import cn.edu.ntu.javaee.boot.common.constants.HttpConstants;
import cn.edu.ntu.javaee.boot.common.response.ErrorMessageEnum;
import cn.edu.ntu.javaee.boot.common.response.ErrorResponse;
import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.management.BadStringOperationException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;

/**
 * @author zack
 * @create 2019-12-25 22:40
 * @function base exception handler, if extends by others controller, will return 200.
 */
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
  /**
   * will handle by CustomErrorAttributes
   *
   * @param e
   * @param request
   * @return
   */
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

  /**
   * will handle by CustomErrorAttributes
   *
   * @param e
   * @param request
   * @return
   */
  @ExceptionHandler(BadStringOperationException.class)
  public ModelAndView handleBadStringOperationException(
      BadStringOperationException e, HttpServletRequest request) {

    return new ModelAndView(new String());
  }

  /**
   * will not handle by CustomErrorAttributes
   *
   * @param e
   * @param request
   * @return
   */
  @ExceptionHandler(RuntimeException.class)
  @ResponseBody
  public ErrorResponse handleRuntimeException(RuntimeException e, HttpServletRequest request) {

    ErrorResponse errorResponse = ErrorResponse.error(ErrorMessageEnum.UNKNOWN_EXCEPTION);
    errorResponse.setParameters(MapUtil.of("Cause", e.getCause()));

    return errorResponse;
  }

  /**
   * will not handle by CustomErrorAttributes
   *
   * <p><code>ResponseEntity</code> is status and (T) body, so we can put our response to body, and
   * specify http status code.
   *
   * @param e
   * @param request
   * @return <code>ResponseEntity</code> , and response body is <code>ErrorResponse</code>
   */
  @ExceptionHandler(InvalidPropertiesFormatException.class)
  public ResponseEntity handleRuntimeException2(
      InvalidPropertiesFormatException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;

    ErrorResponse errorResponse = ErrorResponse.error(ErrorMessageEnum.UNKNOWN_EXCEPTION);
    errorResponse.setParameters(MapUtil.of("Cause", e.getCause()));

    return new ResponseEntity<>(errorResponse, status);
  }

  /**
   * will handle by CustomErrorAttributes
   *
   * @param e
   * @param request
   * @return
   */
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
