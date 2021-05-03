package mq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * 流程
 *
 * <pre>
 *     1. publisher 消息先到 direct-dead-exchange
 *     2. 根据 dead-routing-key 加入 direct-dead-queue
 *     3. consumer 消费失败后带上 dead-dl-routing-key 作为 routingkey 发送到 direct-dead-dl-exchange
 *     4. 在根据 dead-dl-routing-key 发送到 direct-dead-dl-queue
 * </pre>
 *
 * @author zack <br>
 * @create 2021-03-07 14:04 <br>
 * @project mq <br>
 */
@Configuration
public class RabbitmqDirectDeadDeclareConfiguration {

    private String deadExchangeName = "direct-dead-dl-exchange";
    private String deadQueueName = "direct-dead-dl-queue";
    private String deadRoutingKey = "dead-dl-routing-key";
    private String exchangeName = "direct-dead-exchange";
    private String queueName = "direct-dead-queue";
    private String routingKey = "dead-routing-key";
    ;

    @Bean
    public Exchange directExchange() {

        return new DirectExchange(exchangeName, true, false);
    }

    /**
     * 1. 声明正常的 queue 并绑定 DL 相关的参数<br>
     * 2. 需要进入 dl-queue 时会抛弃之前的 routingkey, 并带上 deadRoutingKey 作为 routingkey 发送到 deadExchangeName
     *
     * @return
     */
    @Bean
    public Queue directQueue() {
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("x-dead-letter-exchange", deadExchangeName);
        map.put("x-dead-letter-routing-key", deadRoutingKey);
        return new Queue(queueName, true, false, false, map);
    }

    @Bean
    public Binding directBinding() {

        return new Binding(
                queueName, Binding.DestinationType.QUEUE, exchangeName, routingKey, null);
    }

    @Bean
    public Exchange directDeadExchange() {
        return new DirectExchange(deadExchangeName, true, false);
    }

    @Bean
    public Queue directDeadQueue() {
        return new Queue(deadQueueName, true, false, false);
    }

    @Bean
    public Binding directDeadBinding() {

        return new Binding(
                deadQueueName,
                Binding.DestinationType.QUEUE,
                deadExchangeName,
                deadRoutingKey,
                null);
    }
}
