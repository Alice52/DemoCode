package cloud.grpc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author asd <br>
 * @create 2021-06-28 12:57 PM <br>
 * @project cloud-grpc-server <br>
 */
@SpringBootApplication
public class GrpcServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcServerApplication.class, args);
    }
}
