package mq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

/**
 * {@link RabbitAutoConfiguration} 作用会放入 RabbitConnectionFactoryBean, RabbitTemplate, amqpAdmin
 *
 * <pre>
 *     1. amqpAdmin 创建相关的 queue, exchange, bind
 * </pre>
 *
 * @author zack <br>
 * @create 2021-03-06 20:57 <br>
 * @project mq <br>
 */
@SpringBootApplication
@EnableRabbit
public class SenderApplication {
  public static void main(String[] args) {
    SpringApplication.run(SenderApplication.class, args);
  }
}
