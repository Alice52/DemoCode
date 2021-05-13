package boot.security.exception;

import boot.security.common.Status;
import lombok.EqualsAndHashCode;

/**
 * @author zack <br>
 * @create 2021-05-13<br>
 * @project integration <br>
 */
@EqualsAndHashCode(callSuper = true)
public class SecurityException extends BaseException {
    public SecurityException(Status status) {
        super(status);
    }

    public SecurityException(Status status, Object data) {
        super(status, data);
    }

    public SecurityException(Integer code, String message) {
        super(code, message);
    }

    public SecurityException(Integer code, String message, Object data) {
        super(code, message, data);
    }
}
