package boot.web.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zack <br>
 * @create 2021-04-26 12:02 <br>
 * @project boot-security-shiro <br>
 */
@SpringBootApplication
public class UndertowApplication {
    public static void main(String[] args) {
        SpringApplication.run(UndertowApplication.class, args);
    }
}
