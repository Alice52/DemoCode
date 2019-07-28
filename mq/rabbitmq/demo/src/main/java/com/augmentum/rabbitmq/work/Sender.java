package com.augmentum.rabbitmq.work;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zack
 * @create 2019-07-28 12:51
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
            channel.queueDeclare(Constants.WORK_QUEUE_NAME, true, false, false, null);

            String message = String.join(" ", Constants.WORK_QUEUE_MESSAGE);

            for(int i =0;i< 1000; i++) {

                channel.basicPublish("", Constants.WORK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
                LOG.info(" [x] Sent '" + message + "'");
            }
        } catch (IOException e) {
            LOG.error("RabbitMQ: sendMsg IO exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        } finally {
            ConnectionUtils.closeConnection(channel, connection);
        }
    }

}
