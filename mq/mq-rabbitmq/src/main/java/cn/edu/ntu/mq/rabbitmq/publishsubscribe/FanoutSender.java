package cn.edu.ntu.mq.rabbitmq.publishsubscribe;

import cn.edu.ntu.mq.constants.Constants;
import cn.edu.ntu.mq.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zack
 * @create 2019-07-28 14:18
 * @function
 */
public class FanoutSender {

    private static final Logger LOG = LoggerFactory.getLogger(FanoutSender.class);
    private static Connection connection = ConnectionUtils.getConnection();

    public static void main(String[] args) {
        sendMsg();
    }

    public static void sendMsg() {
        Channel channel = null;
        try {
            channel = connection.createChannel();
            channel.exchangeDeclare(Constants.EXCHANGE_LOG_NAME, "fanout");

            String message = Constants.WPUBLISH_QUEUE_MESSAGE;

            channel.basicPublish(Constants.EXCHANGE_LOG_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (IOException e) {
            LOG.error("RabbitMQ: sendMsg IO exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        } finally {
            ConnectionUtils.closeConnection(channel,connection);
        }

    }
}
