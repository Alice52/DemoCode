package boot.security.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zack <br>
 * @create 2021-05-13 12:45 <br>
 * @project boot-security-shiro <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    /** token 字段 */
    private String token;
    /** token类型 */
    private String tokenType = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }
}
