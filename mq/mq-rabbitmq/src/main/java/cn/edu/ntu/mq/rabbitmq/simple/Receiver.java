package cn.edu.ntu.mq.rabbitmq.simple;

import cn.edu.ntu.mq.constants.Constants;
import cn.edu.ntu.mq.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zack
 * @create 2019-07-28 11:56
 * @function
 */
public class Receiver {
    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
    private static Connection connection = ConnectionUtils.getConnection();

    public static void main(String[] args) {
            receiveMsg();
    }

    private static void receiveMsg() {

        Channel channel;

        try {
            channel = connection.createChannel();

            channel.queueDeclare(Constants.SIMPLE_QUEUE_NAME, false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                LOG.info(" [x] Received '" + message + "'");
            };

            channel.basicConsume(Constants.SIMPLE_QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        } catch (IOException e) {
            LOG.error("RabbitMQ: receiveMsg IO exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        } finally {
            // ConnectionUtils.closeConnection(channel,connection);
        }
    }
}
