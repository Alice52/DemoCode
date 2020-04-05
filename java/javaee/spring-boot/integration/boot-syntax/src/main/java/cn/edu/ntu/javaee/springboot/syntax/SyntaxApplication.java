package cn.edu.ntu.javaee.springboot.syntax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/** @author zack */
@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class SyntaxApplication {

  public static void main(String[] args) {
    SpringApplication.run(SyntaxApplication.class, args);
  }
}
