package mq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在容器初始化的时候创建相关的 queue, exchange, binding
 *
 * @author zack <br>
 * @create 2021-03-07 14:04 <br>
 * @project mq <br>
 */
@Configuration
public class RabbitmqDirectDeclareConfiguration {

    @Value("${mq.direct.exchange}")
    private String exchangeName;

    @Value("${mq.direct.queue}")
    private String queueName;

    @Value("${mq.direct.routing-key}")
    private String routingKey;

    @Bean
    public Queue directQueue() {

        return new Queue(queueName, true, false, false);
    }

    @Bean
    public Exchange directExchange() {

        return new DirectExchange(exchangeName, true, false);
    }

    @Bean
    public Binding directBinding() {
        /*
         * String destination, 目的地（队列名或者交换机名字）
         * DestinationType destinationType, 目的地类型（Queue/Exhcange）
         * String exchange,
         * String routingKey,
         * Map<String, Object> arguments
         * */
        return new Binding(
                queueName, Binding.DestinationType.QUEUE, exchangeName, routingKey, null);
    }
}
