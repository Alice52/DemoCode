package boot.web.actuator.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zack <br>
 * @create 2021-04-20 22:42 <br>
 * @project springboot <br>
 */
@SpringBootApplication
public class ActuatorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorClientApplication.class, args);
    }
}
