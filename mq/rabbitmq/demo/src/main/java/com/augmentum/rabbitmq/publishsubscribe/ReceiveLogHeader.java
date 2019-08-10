package com.augmentum.rabbitmq.publishsubscribe;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.util.HashMap;
import java.util.Map;

public class ReceiveLogHeader {
    private static final String EXCHANGE_NAME = "header_test";

    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.HEADERS);

        // The API requires a routing key, but in fact if you are using a header exchange the
        // value of the routing key is not used in the routing. You can receive information
        // from the sender here as the routing key is still available in the received message.
        String routingKeyFromUser = "ourTestRoutingKey";

        // Argument processing: the first arg is the local queue name, the rest are
        // key value pairs for headers.

        // The map for the headers.
        Map<String, Object> headers = new HashMap<>();

        headers.put("SOAP_ACTION", "greet");

        String queueName = channel.queueDeclare(Constants.SIMPLE_QUEUE_NAME, false, false, false, null).getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, routingKeyFromUser, headers);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
}

