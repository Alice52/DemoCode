package cn.edu.ntu.integration.activemqsender.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author zack
 * @create 2019-10-05 18:11
 * @function
 */
@Component
@EnableJms
public class ConfigBean {

  @Value("${queue-name}")
  private String queueName;

  @Bean
  public Queue queue() {
    return new ActiveMQQueue(queueName);
  }

  @Value("${topic-name}")
  private String topicName;

  @Bean
  public Topic topic() {
    return new ActiveMQTopic(topicName);
  }


}
