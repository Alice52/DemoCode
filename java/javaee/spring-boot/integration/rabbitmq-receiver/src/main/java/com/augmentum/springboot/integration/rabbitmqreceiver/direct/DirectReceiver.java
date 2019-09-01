package com.augmentum.springboot.integration.rabbitmqreceiver.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zack
 * @create 2019-09-01 3:26 PM
 * @function
 */
@Component
@RabbitListener(queues = "${queue.direct}")
public class DirectReceiver {

  @Autowired AmqpAdmin amqpAdmin;

  @Value("${exchange.direct}")
  private String DIRECT_EXCHANGE;

  @Value("${queue.direct}")
  private String DIRECT_QUEUE;

  @Value("${direct.routing.key}")
  private String DIRECT_ROUTING_KEY;

  @Value("${exchange.topic}")
  private String TOPIC_EXCHANGE;

  @Value("${queue.topic}")
  private String TOPIC_QUEUE;

  @Value("${queue.direct}")
  private String queueName;

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());

  @RabbitHandler
  public void process(Object content) {
    LOG.info(
        "[{}] Get message from {}, message detail: {} ", ExchangeTypes.DIRECT, queueName, content);
  }

  @PostConstruct
  public void init() {
    amqpAdmin.declareExchange(new DirectExchange(DIRECT_EXCHANGE));
    amqpAdmin.declareQueue(new Queue(DIRECT_QUEUE, true));

    amqpAdmin.declareBinding(
        new Binding(
            DIRECT_QUEUE,
            Binding.DestinationType.QUEUE,
            DIRECT_EXCHANGE,
            DIRECT_ROUTING_KEY,
            null));
  }
}
