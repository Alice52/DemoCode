package cn.edu.ntu.integration.rabbitmqreceiver.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zack
 * @create 2019-09-01 4:04 PM
 * @function
 */
@Component
public class TopicReceiver {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired AmqpAdmin amqpAdmin;

    @Value("${exchange.topic}")
    private String TOPIC_EXCHANGE;

    @Value("${queue.topic}")
    private String TOPIC_QUEUE;

    @RabbitListener(queues = "${queue.topic}")
    @RabbitListener(
            bindings =
                    @QueueBinding(
                            value = @Queue(value = "${queue.topic}", durable = "true"),
                            exchange =
                                    @Exchange(
                                            name = "${exchange.topic}",
                                            durable = "true",
                                            type = "topic"),
                            key = {"topicsKey.*", "topicsKey.#"}))
    @RabbitHandler
    public void process(Object content) {
        LOG.info(
                "[{}] Get message from {}, message detail: {} ",
                ExchangeTypes.TOPIC,
                TOPIC_QUEUE,
                content);
    }

    //  private static final String[] topicsRoutingKeys = new String[] {"topicsKey.*",
    // "topicsKey.#"};
    //  @PostConstruct
    //  public void init() {
    //    amqpAdmin.declareExchange(new TopicExchange(TOPIC_EXCHANGE));
    //    amqpAdmin.declareQueue(new Queue(TOPIC_QUEUE, true));
    //
    //    for (String topicsRoutingKey : topicsRoutingKeys) {
    //      amqpAdmin.declareBinding(
    //          new Binding(
    //              TOPIC_QUEUE, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, topicsRoutingKey,
    // null));
    //    }
    //  }
}
