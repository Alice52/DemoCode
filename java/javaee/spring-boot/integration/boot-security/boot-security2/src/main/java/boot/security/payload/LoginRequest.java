package boot.security.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zack <br>
 * @create 2021-05-13 12:41 <br>
 * @project boot-security-shiro <br>
 */
@Data
public class LoginRequest {

    /** 用户名或邮箱或手机号 */
    @NotBlank(message = "用户名不能为空")
    private String usernameOrEmailOrPhone;

    /** 密码 */
    @NotBlank(message = "密码不能为空")
    private String password;

    /** 记住我 */
    private Boolean rememberMe = false;
}
