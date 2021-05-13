package boot.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zack <br>
 * @create 2021-05-13 12:11 <br>
 * @project boot-security-shiro <br>
 */
@ConfigurationProperties(prefix = "custom.config")
@Data
public class CustomConfig {
    /** 不需要拦截的地址 */
    private IgnoreConfig ignores;
}
