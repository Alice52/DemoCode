package cn.edu.ntu.boot.exception.sample.handler;

import cn.edu.ntu.boot.exception.sample.exception.BusinessException;
import cn.edu.ntu.javaee.boot.common.response.ErrorMessageEnum;
import cn.edu.ntu.javaee.boot.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zack <br>
 * @create 2021-04-25 13:26 <br>
 * @project integration <br>
 */
@Order(100)
@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ErrorResponse exception(BusinessException e) {

        log.info("BusinessException: {}", e);
        return ErrorResponse.error(ErrorMessageEnum.UNKNOWN_EXCEPTION);
    }
}
