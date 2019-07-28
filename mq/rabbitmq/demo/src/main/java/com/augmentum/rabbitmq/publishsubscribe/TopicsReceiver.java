package com.augmentum.rabbitmq.publishsubscribe;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zack
 * @create 2019-07-28 15:05
 * @function
 */
public class TopicsReceiver {
    private static final Logger LOG = LoggerFactory.getLogger(TopicsReceiver.class);
    private static Connection connection = ConnectionUtils.getConnection();
    // *表示只匹配一个词
    // #表示匹配多个词
    private static final String[] topicsGuides = new String[]{"topicsKey.*", "topicsKey.#"};

    public static void main(String[] args) {
        receiveMsg();
    }

    private static void receiveMsg() {

        Channel channel;

        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(Constants.EXCHANGE_TOPICS_NAME, BuiltinExchangeType.TOPIC);
            String queueName = channel.queueDeclare().getQueue();

            for (String s : topicsGuides) {
                channel.queueBind(queueName, Constants.EXCHANGE_TOPICS_NAME, s);
            }

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                LOG.info(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
            };

            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
        } catch (IOException e) {
            LOG.error("RabbitMQ: receiveMsg IO exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        } finally {
            // close resources
        }
    }
}
