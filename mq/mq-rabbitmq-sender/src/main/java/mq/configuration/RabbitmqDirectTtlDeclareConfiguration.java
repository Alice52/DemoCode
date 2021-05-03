package mq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * 在容器初始化的时候创建相关的 queue, exchange, binding
 *
 * @author zack <br>
 * @create 2021-03-07 14:04 <br>
 * @project mq <br>
 */
@Configuration
public class RabbitmqDirectTtlDeclareConfiguration {

    @Value("${mq.direct.ttl.exchange}")
    private String exchangeName;

    @Value("${mq.direct.ttl.queue}")
    private String queueName;

    @Value("${mq.direct.ttl.routing-key}")
    private String routingKey;

    @Bean
    public Queue directTtlQueue() {
        HashMap<String, Object> arguments = new HashMap<>(2);
        arguments.put("x-message-ttl", 60_000);

        return new Queue(queueName, true, false, false, arguments);
    }

    @Bean
    public Exchange directTtlExchange() {

        return new DirectExchange(exchangeName, true, false);
    }

    @Bean
    public Binding directTtlBinding() {

        // 消息过期时间 1分钟
        return new Binding(
                queueName, Binding.DestinationType.QUEUE, exchangeName, routingKey, null);
    }
}
