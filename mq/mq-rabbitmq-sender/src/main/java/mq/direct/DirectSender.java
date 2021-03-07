package mq.direct;

import cn.edu.ntu.mq.model.Person;
import cn.hutool.core.util.IdUtil;
import lombok.SneakyThrows;
import mq.configuration.RabbitmqDirectDeclareConfiguration;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * rabbitmq 的生产端的最终使用方法
 *
 * <pre>
 *     1. 需要对相关的 exchange, queue, binding 做初始化工作
 *     2. 配置 setMessageConverter 做对象转换: mq 中是 json 类型的数据格式
 *     3. 发送消息时需要设置 setCorrelationId: MessagePostProcessor
 *     4. 发送端注意问题
 *        - 消息丢失:
 *        - 消息重复:
 * </pre>
 *
 * @author zack <br>
 * @create 2021-03-06 20:44 <br>
 * @project mq <br>
 */
@Component
public class DirectSender {

  @Value("${mq.direct.exchange}")
  private String exchangeName;

  @Value("${mq.direct.queue}")
  private String queueName;

  @Value("${mq.direct.routing-key}")
  private String routingKey;

  @Autowired RabbitTemplate rabbitTemplate;

  @Autowired AmqpAdmin amqpAdmin;

  /** replaced by {@link RabbitmqDirectDeclareConfiguration } */
  //  @PostConstruct
  //  public void init() {
  //    amqpAdmin.declareExchange(new DirectExchange(exchangeName, true, false));
  //    amqpAdmin.declareQueue(new Queue(queueName, true, false, false));
  //    amqpAdmin.declareBinding(
  //        new Binding(queueName, Binding.DestinationType.QUEUE, exchangeName, routingKey, null));
  //  }

  @SneakyThrows
  public void sendImmediately() {
    // https://docs.spring.io/spring-amqp/docs/1.6.11.RELEASE/reference/html/_reference.html#_converting_from_a_message_2
    // 发送 map consumer 会报错: 只能使用 Object 接受
    rabbitTemplate.convertAndSend(exchangeName, routingKey, "immediately message");

    TimeUnit.SECONDS.sleep(5);

    String uuid = IdUtil.simpleUUID();
    rabbitTemplate.convertAndSend(
        exchangeName,
        routingKey,
        new Person("zack", 18),
        m -> {
          m.getMessageProperties().setCorrelationId(uuid);
          return m;
        },
        new CorrelationData(uuid));
  }
}
