package boot.security.constants.enums;

import cn.edu.ntu.common.api.exception.assertion.IBusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-05-13 12:30 <br>
 * @project boot-security-shiro <br>
 */
@Getter
@AllArgsConstructor
public enum SecurityResponseEnum implements IBusinessExceptionAssert {
    NO_AUTHORIZATION(401, "Authorization Failed."),
    NO_PERMISSION(403, "No Permission."),
    NO_FOUND(404, "Not Found");

    private Integer errorCode;
    private String errorMsg;
    private Map<String, Object> parameters;

    SecurityResponseEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
