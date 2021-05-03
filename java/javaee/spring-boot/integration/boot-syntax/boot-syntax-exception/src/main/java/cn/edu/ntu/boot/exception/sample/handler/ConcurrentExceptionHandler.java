package cn.edu.ntu.boot.exception.sample.handler;

import cn.edu.ntu.boot.exception.sample.exception.BusinessException;
import cn.edu.ntu.javaee.boot.common.response.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/**
 * @author zack <br>
 * @create 2021-04-25 13:21 <br>
 * @project integration <br>
 */
@Order(100)
@RestControllerAdvice
public class ConcurrentExceptionHandler {

    @Resource GlobalExceptionHandler globalExceptionHandler;
    @Resource BusinessExceptionHandler businessExceptionHandler;

    @ExceptionHandler(ExecutionException.class)
    public ErrorResponse executionException(ExecutionException e) {
        return tryConvert2BusinessException(e);
    }

    @ExceptionHandler(CompletionException.class)
    public ErrorResponse completionException(CompletionException e) {
        return tryConvert2BusinessException(e);
    }

    private ErrorResponse tryConvert2BusinessException(Exception e) {
        if (e.getCause() instanceof BusinessException) {
            // this will try to convert to UserNotExistException first
            return businessExceptionHandler.exception((BusinessException) e.getCause());
        }

        return globalExceptionHandler.exception(e);
    }
}
