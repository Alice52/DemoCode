package cn.edu.ntu.integration.rabbitmqsender.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zack
 * @create 2019-09-01 1:53 PM
 * @function the direct sender
 */
@Component
public class DirectSender {
  private static final Logger LOG = LoggerFactory.getLogger(DirectSender.class);

  // @Autowired private Queue directQueue;

  @Value("${exchange.direct}")
  private String DIRECT_EXCHANGE;

  @Value("${queue.direct}")
  private String DIRECT_QUEUE;

  @Value("${direct.routing.key}")
  private String DIRECT_ROUTING_KEY;

  private static final String DIRECT_MESSAGE = "hello direct";

  @Autowired RabbitTemplate rabbitTemplate;

  @Autowired AmqpAdmin amqpAdmin;

  public void directSender() {

    rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, DIRECT_ROUTING_KEY, DIRECT_MESSAGE);
    LOG.info(
        "{} Send message to {} success, message detail: {}",
        ExchangeTypes.DIRECT,
        DIRECT_QUEUE,
        DIRECT_MESSAGE);

    Map<String, Number> map = new HashMap<>();
    map.put("hello", 1);
    // this message will be convert to byte[]
    rabbitTemplate.convertAndSend(DIRECT_EXCHANGE, DIRECT_ROUTING_KEY, map);

    LOG.info(
        "{} Send message to {} success, message detail: {}",
        ExchangeTypes.DIRECT,
        DIRECT_QUEUE,
        map);
  }

  @Scheduled(fixedDelay = 3000)
  public void directSenderScheduled() {
    directSender();
  }

  @PostConstruct
  public void init() {
    amqpAdmin.declareExchange(new DirectExchange(DIRECT_EXCHANGE));
  }

  // the follow config is not sub/pub
  //  @PostConstruct
  //  public void init() {
  //    amqpAdmin.declareExchange(new DirectExchange(DIRECT_EXCHANGE));
  //    amqpAdmin.declareQueue(new Queue(DIRECT_QUEUE, true));
  //
  //    amqpAdmin.declareBinding(
  //        new Binding(
  //            DIRECT_QUEUE,
  //            Binding.DestinationType.QUEUE,
  //            DIRECT_EXCHANGE,
  //            DIRECT_ROUTING_KEY,
  //            null));
  //  }
}
