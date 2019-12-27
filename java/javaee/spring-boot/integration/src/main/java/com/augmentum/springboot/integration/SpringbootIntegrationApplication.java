package com.augmentum.springboot.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class SpringBootIntegrationApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootIntegrationApplication.class, args);
  }
}
