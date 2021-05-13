package boot.security.config;

import boot.security.common.Status;
import boot.security.util.ResponseUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author zack <br>
 * @create 2021-05-13 12:17 <br>
 * @project boot-security-shiro <br>
 */
@Configuration
public class SecurityHandlerConfig {

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) ->
                ResponseUtil.renderJson(response, Status.ACCESS_DENIED, null);
    }
}
