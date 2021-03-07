package mq.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static org.springframework.amqp.support.converter.Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID;

/**
 * @author zack <br>
 * @create 2021-03-06 22:59 <br>
 * @project mq <br>
 */
@Slf4j
@Component
public class RabbitmqConfiguration {
  RabbitTemplate rabbitTemplate;;

  /**
   * 不使用该方法@Bean, 可以在配置文件中配置
   *
   * @return
   */
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
    return connectionFactory;
  }

  @Order(2)
  @Primary
  @Bean
  public RabbitTemplate rabbitTemplate(
      ConnectionFactory connectionFactory, Jackson2JsonMessageConverter converter) {
    rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(converter);

    initRabbitmqCallback();

    return rabbitTemplate;
  }

  @Order(1)
  @Bean
  public Jackson2JsonMessageConverter converter() {
    Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
    converter.setTypePrecedence(TYPE_ID);
    return converter;
  }

  /** */
  public void initRabbitmqCallback() {

    // important
    rabbitTemplate.setMandatory(true);
    rabbitTemplate.setConfirmCallback(
        // ack: 这个表示是否成功发送到 broker
        (correlationData, ack, cause) -> {
          log.info(
              "ConfirmCallback: correlationData: {} ack: {} cause:{}", correlationData, ack, cause);
        });

    rabbitTemplate.setReturnCallback(
        // 消息没有被发送到 queue 才会调用
        (message, replyCode, replyText, exchange, routingKey) -> {
          log.info(
              "ReturnCallback: Fail message: {} replyCode: {} replyText:{} exchange: {} routingKey: {}",
              message,
              replyCode,
              replyText,
              exchange,
              routingKey);
        });
  }
}
