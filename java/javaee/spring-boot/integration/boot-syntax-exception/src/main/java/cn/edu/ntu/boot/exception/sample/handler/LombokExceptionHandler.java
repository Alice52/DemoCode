package cn.edu.ntu.boot.exception.sample.handler;

import cn.edu.ntu.javaee.boot.common.response.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/**
 * @author zack <br>
 * @create 2021-04-25 13:22 <br>
 * @project integration <br>
 */
@Order(100)
@RestControllerAdvice
public class LombokExceptionHandler {

  @Resource private ConcurrentExceptionHandler concurrentExceptionHandler;

  @ExceptionHandler(UndeclaredThrowableException.class)
  public ErrorResponse undeclaredThrowableException(UndeclaredThrowableException e) {
    return tryConvert2ConcurrentException(e);
  }

  private ErrorResponse tryConvert2ConcurrentException(UndeclaredThrowableException e) {
    if (e.getUndeclaredThrowable() instanceof ExecutionException) {
      return concurrentExceptionHandler.executionException(
          (ExecutionException) e.getUndeclaredThrowable());
    }

    if (e.getUndeclaredThrowable() instanceof CompletionException) {
      return concurrentExceptionHandler.completionException(
          (CompletionException) e.getUndeclaredThrowable());
    }

    return concurrentExceptionHandler.globalExceptionHandler.exception(e);
  }
}
