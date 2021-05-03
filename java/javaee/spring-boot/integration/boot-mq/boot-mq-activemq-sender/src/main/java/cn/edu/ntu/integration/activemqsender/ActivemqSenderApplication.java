package cn.edu.ntu.integration.activemqsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActivemqSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqSenderApplication.class, args);
    }
}
