package mq.direct;

import cn.edu.ntu.mq.model.Person;
import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * consumer 端的使用方法
 *
 * <pre>
 *    1. 需要对相关的 exchange, queue, binding 做初始化工作
 *    2. 最终的使用方法是每个 Consumer 只能从指定的一个 queue 中取消息: @RabbitListener
 *    3. 一个 queue 中的不同类型的消息会被不同的方法处理: @RabbitHandler
 * </pre>
 *
 * @author zack <br>
 * @create 2021-03-06 20:44 <br>
 * @project mq <br>
 */
@RabbitListener(queues = "${mq.direct.queue}")
@Component
@Slf4j
public class DirectConsumer {

  @Value("${mq.direct.exchange}")
  private String exchangeName;

  @Value("${mq.direct.queue}")
  private String queueName;

  @Value("${mq.direct.routing-key}")
  private String routingKey;

  @Autowired RabbitTemplate rabbitTemplate;

  @Autowired AmqpAdmin amqpAdmin;

  @PostConstruct
  public void init() {
    // String name, boolean durable, boolean autoDelete
    amqpAdmin.declareExchange(new DirectExchange(exchangeName, true, false));
    // String name, boolean durable, boolean exclusive, boolean autoDelete
    amqpAdmin.declareQueue(new Queue(queueName, true, false, false));
    // String destination, DestinationType destinationType, String exchange,
    // String routingKey, @Nullable Map<String, Object> arguments
    amqpAdmin.declareBinding(
        new Binding(queueName, Binding.DestinationType.QUEUE, exchangeName, routingKey, null));
  }

  /**
   * 消费端特点
   *
   * <pre>
   *    1. 此时如果启动多个 consumer 则一条消息只能被某一个 consumer 获取进行消费
   *    2. 此时代码是消费完一次消息才会去拿第二次, 每次多少个可以通过prefetch_count设置
   *    3. 此时在消息处理过程中出现异常或者 consumer 服务器宕机了, 则队列中的消息就会丢失
   *        - 原因: consumer 自动 ack 导致的消息丢失
   *        - 方法: 手动确认 ack
   * </pre>
   *
   * @param content
   */
  //    @RabbitHandler
  //    @SneakyThrows
  //    public void receive(Message message, Object content, Channel channel) {
  //
  //      TimeUnit.SECONDS.sleep(10);
  //
  //      log.info(
  //          "Get message from {}, message properties: {}", queueName,
  //   message.getMessageProperties());
  //      log.info("Get message from {}, message detail: {} ", queueName, content);
  //    }

  @SneakyThrows
  @RabbitHandler
  public void receive(Message message, String content, Channel channel) {

    MessageProperties properties = message.getMessageProperties();
    log.info(
        "Get message from {}, message properties: {}, message body[json]: {}",
        queueName,
        properties,
        content);

    channel.basicAck(properties.getDeliveryTag(), false);
  }

  @SneakyThrows
  @RabbitHandler
  public void receive(@Payload Person content, Message message, Channel channel) {
    MessageProperties properties = message.getMessageProperties();

    log.info(
        "Get message from {}, message properties: {}, message body[json]: {}",
        queueName,
        properties,
        content);

    // 拒绝 ack 改消息并重新 requeue
    channel.basicNack(properties.getDeliveryTag(), false, false);
  }
}
