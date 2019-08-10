package com.augmentum.rabbitmq.publishsubscribe;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zack
 * @create 2019-07-28 15:05
 * @function
 */
public class TopicsSender {

    private static final Logger LOG = LoggerFactory.getLogger(TopicsSender.class);
    private static Connection connection = ConnectionUtils.getConnection();

    private static final String[] topicsGuides = new String[]{"topicsKey.aa", "topicsKey.bb", "topicsKey.cc.ee"};


    public static void main(String[] args) {
        sendMsg();
    }

    public static void sendMsg() {
        Channel channel = null;
        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(Constants.EXCHANGE_TOPICS_NAME, BuiltinExchangeType.TOPIC);

            String message = Constants.WPUBLISH_QUEUE_MESSAGE;

            for (String key: topicsGuides){
                channel.basicPublish(Constants.EXCHANGE_TOPICS_NAME, key, null, message.getBytes("UTF-8"));
                LOG.info(" [x] Sent '" + key + "':'" + message + "'");
            }
        } catch (IOException e) {
            LOG.error("RabbitMQ: sendMsg IO exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        } finally {
            ConnectionUtils.closeConnection(channel, connection);
        }

    }
}