package boot.webflux.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * @author zack <br>
 * @create 2021-04-11 11:45 <br>
 * @project springboot <br>
 */
@SpringBootApplication
@EnableReactiveMongoRepositories
public class WebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class, args);
    }
}
