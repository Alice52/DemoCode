package mq.direct;

import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2021-03-06 20:44 <br>
 * @project mq <br>
 */
@Component
public class DirectDeadSender {

  private String exchangeName = "direct-dead-exchange";
  private String routingKey = "dead-routing-key";;

  @Autowired RabbitTemplate rabbitTemplate;

  /**
   * 三种方式可以使消息进入 DLQ
   *
   * <pre>
   *     1. queue 达到最大的长度
   *     2. consumer 拒绝收消息并将设置 re-queue 为 false
   *     3. 消息过期
   * </pre>
   */
  @SneakyThrows
  public void sendImmediately() {
    rabbitTemplate.convertAndSend(
        exchangeName,
        routingKey,
        "immediately message",
        m -> {
          m.getMessageProperties().setExpiration("1000000");
          return m;
        });
  }
}
