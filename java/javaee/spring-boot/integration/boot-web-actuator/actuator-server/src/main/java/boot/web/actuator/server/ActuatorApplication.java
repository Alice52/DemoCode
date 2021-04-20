package boot.web.actuator.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zack <br>
 * @create 2021-04-20 22:04 <br>
 * @project springboot <br>
 */
@SpringBootApplication
@EnableAdminServer
public class ActuatorApplication {
  public static void main(String[] args) {

    SpringApplication.run(ActuatorApplication.class, args);
  }
}
