package cn.edu.ntu.boot.exception.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Comments:
 *
 * <pre>
 *     1. This project will throw {@link org.springframework.beans.factory.BeanCurrentlyInCreationException}
 *         when it's starting up with interface marked by {@link org.springframework.validation.annotation.Validated}.
 *
 *         - `/hello-a?name=sd` this api when call b interface's validator will not work.
 *         - solution: https://blog.csdn.net/nazeniwaresakini/article/details/104220312
 *
 *     2. spring boot validators usages:
 *        - https://docs.spring.io/spring-boot/docs/2.1.10.RELEASE/reference/html/boot-features-validation.html
 * </pre>
 *
 * @author zack <br>
 * @create 2021-04-25 13:30 <br>
 * @project integration <br>
 */
@SpringBootApplication
public class ExceptionSample {
  public static void main(String[] args) {
    SpringApplication.run(ExceptionSample.class, args);
  }
}
