package boot.security.exception;

import cn.edu.ntu.common.api.exception.BaseException;

/**
 * @author zack <br>
 * @create 2021-05-13 12:24 <br>
 * @project boot-security-shiro <br>
 */
public class SecurityException extends BaseException {

    public SecurityException(Integer code, String message) {
        super(code, message);
    }
}
