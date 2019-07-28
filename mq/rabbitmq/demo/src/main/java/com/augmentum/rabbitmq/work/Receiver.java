package com.augmentum.rabbitmq.work;

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
 * @create 2019-07-28 12:51
 * @function
 */
public class Receiver {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
    private static Connection connection = ConnectionUtils.getConnection();

    public static void main(String[] argv) {
        for (int i=0; i<1000; i++) {
            receiveMsg();
        }
    }

    private static void receiveMsg() {
        final Channel channel;
        try {
            channel = connection.createChannel();
            channel.queueDeclare(Constants.WORK_QUEUE_NAME, true, false, false, null);

            // Fair dispatch
            channel.basicQos(1);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");

                LOG.info(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } finally {
                    LOG.info(" [x] Done");
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                }
            };
            channel.basicConsume(Constants.WORK_QUEUE_NAME, false, deliverCallback, consumerTag -> { });
        } catch (IOException e) {
            LOG.error("RabbitMQ: receiveMsg IO exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        }


    }

    private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
