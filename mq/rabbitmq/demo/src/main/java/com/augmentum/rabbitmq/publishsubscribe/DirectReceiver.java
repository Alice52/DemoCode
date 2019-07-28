package com.augmentum.rabbitmq.publishsubscribe;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.augmentum.rabbitmq.publishsubscribe.FanoutReceiver;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zack
 * @create 2019-07-28 14:50
 * @function
 */
public class DirectReceiver {
    private static final Logger LOG = LoggerFactory.getLogger(DirectReceiver.class);
    private static final String[] directGuides = new String[]{"directKey", "directKey1"};

    private static Connection connection = ConnectionUtils.getConnection();

    public static void main(String[] args) {
        receiveMsg();
    }

    private static void receiveMsg() {

        Channel channel;

        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(Constants.EXCHANGE_DIRECT_NAME, BuiltinExchangeType.DIRECT);
            String queueName = channel.queueDeclare().getQueue();

            for (String s : directGuides) {
                channel.queueBind(queueName, Constants.EXCHANGE_DIRECT_NAME, s);
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
