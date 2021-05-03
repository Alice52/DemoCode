package mq.direct;

import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zack <br>
 * @create 2021-03-06 20:44 <br>
 * @project mq <br>
 */
@RabbitListener(queues = "direct-dead-queue")
@Component
@Slf4j
public class DirectDeadConsumer {

    @Autowired RabbitTemplate rabbitTemplate;
    private String queueName = "direct-dead-queue";

    @SneakyThrows
    @RabbitHandler
    public void receive(Message message, String content, Channel channel) {

        MessageProperties properties = message.getMessageProperties();
        log.info(
                "Get message from {}, message properties: {}, message body[json]: {}",
                queueName,
                properties,
                content);

        try {
            channel.basicAck(properties.getDeliveryTag(), false);
        } catch (IOException e) {
            if (properties.getRedelivered()) {
                channel.basicNack(properties.getDeliveryTag(), false, false);
            } else {
                channel.basicNack(properties.getDeliveryTag(), false, true);
            }
        }
    }
}
