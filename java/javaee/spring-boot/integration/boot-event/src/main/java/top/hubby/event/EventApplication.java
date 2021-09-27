package top.hubby.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author asd <br>
 * @create 2021-09-27 2:39 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
@SpringBootApplication
@EnableAsync
public class EventApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);
    }
}
