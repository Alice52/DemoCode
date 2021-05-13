package boot.security.exception;

import boot.security.constants.enums.SecurityResponseEnum;
import cn.edu.ntu.common.api.exception.assertion.IBaseErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zack <br>
 * @create 2021-05-13 12:26 <br>
 * @project boot-security-shiro <br>
 */
@RestControllerAdvice
@Slf4j
@Order(100)
public class SecurityExceptionHandler {
    @ExceptionHandler(value = SecurityException.class)
    public IBaseErrorResponse handlerException(Exception e) {
        return SecurityResponseEnum.NO_AUTHORIZATION;
    }
}
