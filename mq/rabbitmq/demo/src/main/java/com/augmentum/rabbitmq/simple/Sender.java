package com.augmentum.rabbitmq.simple;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * @author zack
 * @create 2019-07-28 10:16
 * @function
 */
public class Sender {


    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    private static Connection connection = ConnectionUtils.getConnection();

    public static void main(String[] args) {
        sendMsg();
    }


    public static void sendMsg() {

        Channel channel = null;

        try {
            channel = connection.createChannel();
            channel.queueDeclare(Constants.SIMPLE_QUEUE_NAME, false, false, false, null);
            String message = Constants.SIMPLE_QUEUE_MESSAGE;
            for (int i=0; i<10; i++) {
                channel.basicPublish("", Constants.SIMPLE_QUEUE_NAME, null, message.getBytes("UTF-8"));
                LOG.info(" [x] Sent '" + message + "'");
            }
        } catch (IOException e) {
            LOG.error("RabbitMQ: sendMsg IO exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        } finally {
            ConnectionUtils.closeConnection(channel,connection);
        }
    }
}
