package com.augmentum.rabbitmq.Utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author zack
 * @create 2019-07-27 18:37
 * @function
 */
public class ConnectionUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ConnectionUtils.class);


    /**
     * @return Connection
     *
     * @function Get the connection of MQ.
     */
    public static Connection getConnection() {
        LOG.info("Start get connection of rabbitmq.");
        Connection connection;
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("101.37.174.197");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        try {
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            LOG.error("RabbitMQ: get connection IO exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        } catch (TimeoutException e) {
            LOG.error("RabbitMQ: get connection TimeoutException exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
            throw new RuntimeException();
        }

        LOG.info("End get connection of rabbitmq success.");
        return connection;
    }


//    public static Channel getChannel() {
//        LOG.info("Start get channel of rabbitmq.");
//
//        Channel channel;
//        Connection connection = ConnectionUtils.getConnection();
//
//        try {
//            channel = connection.createChannel();
//        } catch (IOException e) {
//            LOG.error("RabbitMQ: get channel IOException exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
//            throw new RuntimeException();
//        }
//
//        LOG.info("End get channel of rabbitmq success.");
//        return channel;
//    }


    public static void closeConnection(Channel channel, Connection connection) {
        LOG.info("Start close connection and channel of rabbitmq.");

        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e) {
                LOG.error("RabbitMQ: close channel IOException exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
                throw new RuntimeException();
            } catch (TimeoutException e) {
                LOG.error("RabbitMQ: close channel TimeoutException exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
                throw new RuntimeException();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (IOException e) {
                        LOG.error("RabbitMQ: close connection IOException exception. exception cause: {}; exception message: {}", e.getCause(), e.getMessage());
                        throw new RuntimeException();
                    }
                }
            }
        }

        LOG.info("End close connection and channel of rabbitmq success.");
    }
}
