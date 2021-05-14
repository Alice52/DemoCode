package boot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * admin/123456 <br>
 * user/123456 <br>
 *
 * @author zack <br>
 * @create 2021-04-26 10:52 <br>
 * @project boot-security2 <br>
 */
@SpringBootApplication
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
