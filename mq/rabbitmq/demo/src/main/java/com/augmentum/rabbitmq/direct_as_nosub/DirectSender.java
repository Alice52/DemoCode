package com.augmentum.rabbitmq.direct_as_nosub;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.augmentum.Constants.ROUTING_DIRECT_KEY;

/**
 * @author zack
 * @create 2019-07-28 14:50
 * @function
 */
public class DirectSender {
    private static final Logger LOG = LoggerFactory.getLogger(DirectSender.class);
    private static Connection connection = ConnectionUtils.getConnection();
    public static void main(String[] args) {
        sendMsg();
    }

    public static void sendMsg() {
        Channel channel = null;
        try {
            channel = connection.createChannel();
            channel.queueDeclare(Constants.QUEUE_DIRECT_NAME, false, false, false, null);
            channel.exchangeDeclare(Constants.EXCHANGE_DIRECT_NAME, BuiltinExchangeType.DIRECT);
            channel.queueBind(Constants.QUEUE_DIRECT_NAME, Constants.EXCHANGE_DIRECT_NAME, ROUTING_DIRECT_KEY);

            String message = Constants.WPUBLISH_QUEUE_MESSAGE;

            channel.basicPublish(Constants.EXCHANGE_DIRECT_NAME, ROUTING_DIRECT_KEY, null, message.getBytes("UTF-8"));
            LOG.info(" [x] Sent '" + ROUTING_DIRECT_KEY + "':'" + message + "'");
        } catch (IOException e) {
            LOG.error("RabbitMQ: sendMsg IO exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        } finally {
            ConnectionUtils.closeConnection(channel,connection);
        }

    }
}
