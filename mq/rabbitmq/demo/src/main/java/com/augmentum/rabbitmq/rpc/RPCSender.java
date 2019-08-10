package com.augmentum.rabbitmq.rpc;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zack
 * @create 2019-07-28 15:57
 * @function
 */
public class RPCSender implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(RPCSender.class);
    private static Connection connection = ConnectionUtils.getConnection();
    private Channel channel;

    public RPCSender() {
        try {
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] argv) {
        RPCSender fibonacciRpc = new RPCSender();
        for (int i = 0; i < 32; i++) {
            String i_str = Integer.toString(i);
            System.out.println(" [x] Requesting fib(" + i_str + ")");
            String response = null;
            response = fibonacciRpc.call(i_str);

            System.out.println(" [.] Got '" + response + "'");
        }
    }

    public String call(String message) {
        final String corrId = UUID.randomUUID().toString();
        String result = null;
        String replyQueueName = null;

        try {
            replyQueueName = channel.queueDeclare().getQueue();
            AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().correlationId(corrId).replyTo(replyQueueName).build();

            channel.basicPublish("", Constants.RPC_QUEUE_NAME, props, message.getBytes("UTF-8"));

            final BlockingQueue<String> response = new ArrayBlockingQueue<>(1);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                if (delivery.getProperties().getCorrelationId().equals(corrId)) {
                    response.offer(new String(delivery.getBody(), "UTF-8"));
                }
            };

            String ctag = channel.basicConsume(replyQueueName, true, deliverCallback, consumerTag -> {});

            result = response.take();
            channel.basicCancel(ctag);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void close() throws IOException {
        connection.close();
    }
}
