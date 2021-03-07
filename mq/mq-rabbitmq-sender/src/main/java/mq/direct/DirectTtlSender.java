package mq.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DirectTtlSender {

  @Value("${mq.direct.ttl.exchange}")
  private String exchangeName;

  @Value("${mq.direct.ttl.routing-key}")
  private String routingKey;

  @Autowired RabbitTemplate rabbitTemplate;


    /**
     * Ttl: x-message-ttl
     * <pre>
     *     1. 最终有效的时间: 发送消息时指定的时间和queue 的 ttl 的最小值
     *     2. [设置指定消息的过期时间]只有是在 queue 头部才会在过期后被移除
     *     3. 所以使用时一般是设置 queue 的过期时间
     * </pre>
     */
  public void sendImmediately() {
    rabbitTemplate.convertAndSend(
        exchangeName,
        routingKey,
        "immediately message",
        (m) -> {
          m.getMessageProperties().setExpiration("10000");
          return m;
        });
  }
}
