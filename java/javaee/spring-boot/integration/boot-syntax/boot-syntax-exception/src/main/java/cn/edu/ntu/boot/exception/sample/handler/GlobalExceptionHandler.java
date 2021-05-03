package cn.edu.ntu.boot.exception.sample.handler;

import cn.edu.ntu.javaee.boot.common.response.ErrorMessageEnum;
import cn.edu.ntu.javaee.boot.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Linked:
 *
 * <pre>
 *   1. https://github.com/Alice52/project/tree/project-seckill-plus/backend/project-seckill-api/src/main/java/cn/edu/ntu/seckill/handler
 *      - 多个 handler
 *      - validation handler
 *      - concurrency handler
 * </pre>
 *
 * @author zack <br>
 * @create 2021-04-25 13:10 <br>
 * @project integration <br>
 */
@Order
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErrorResponse exception(Exception e) {

        log.info("Exception: {}", e);
        return ErrorResponse.error(ErrorMessageEnum.UNKNOWN_EXCEPTION);
    }
}
