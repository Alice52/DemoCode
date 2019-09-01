package com.augmentum.springboot.integration.rabbitmqsender.topic;

import com.augmentum.springboot.integration.rabbitmqsender.direct.DirectSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zack
 * @create 2019-09-01 3:42 PM
 * @function
 */
@Component
public class TopicSender {
  private static final Logger LOG = LoggerFactory.getLogger(DirectSender.class);

  private static final String[] topicsRoutingKeys =
      new String[] {"topicsKey.aa", "topicsKey.bb", "topicsKey.cc.ee"};

  @Value("${exchange.topic}")
  private String TOPIC_EXCHANGE;

  @Value("${queue.topic}")
  private String TOPIC_QUEUE;

  private static final String TOPIC_MESSAGE = "hello topic";

  @Autowired public RabbitTemplate rabbitTemplate;

  @Autowired AmqpAdmin amqpAdmin;

  public void topicSender() {
    for (String routingKey : topicsRoutingKeys) {
      rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, routingKey, TOPIC_MESSAGE);
      LOG.info(
          "[{}] Send message to {} success with routing key {}, message detail: {}.",
          ExchangeTypes.TOPIC,
          TOPIC_QUEUE,
          routingKey,
          TOPIC_MESSAGE);
    }
  }

  @Scheduled(fixedDelay = 3000)
  public void topicSenderScheduled() {
    topicSender();
  }

  @PostConstruct
  public void init() {
    amqpAdmin.declareExchange(new TopicExchange(TOPIC_EXCHANGE));
  }
}
