package com.augmentum.rabbitmq.publishsubscribe;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zack
 * @create 2019-07-28 14:18
 * @function
 */
public class FanoutReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(FanoutReceiver.class);
    private static Connection connection = ConnectionUtils.getConnection();

    public static void main(String[] args) {
        receiveMsg();
    }

    private static void receiveMsg() {

        Channel channel;

        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(Constants.EXCHANGE_LOG_NAME, "fanout");
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, Constants.EXCHANGE_LOG_NAME, "");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                LOG.info(" [x] Received '" + message + "'");
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
