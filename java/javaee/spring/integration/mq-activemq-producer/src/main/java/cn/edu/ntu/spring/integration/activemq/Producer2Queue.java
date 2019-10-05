package cn.edu.ntu.spring.integration.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

/**
 * @author zack
 * @create 2019-10-04 21:20
 * @function
 */
@Service
public class Producer2Queue {
  private static final Logger LOGGER = LoggerFactory.getLogger(Producer2Queue.class);

  @Autowired private JmsTemplate jmsTemplate;

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");
    Producer2Queue producer = (Producer2Queue) applicationContext.getBean("producer2Queue");
    producer.jmsTemplate.send(
        session -> {
          TextMessage message = session.createTextMessage("Spring integration ActiveMQ!");
          LOGGER.info("Send text message: {} success.", message);
          return message;
        });
    LOGGER.info("Send message over!");
  }
}
