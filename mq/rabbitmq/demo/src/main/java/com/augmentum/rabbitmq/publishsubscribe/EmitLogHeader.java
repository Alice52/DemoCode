package com.augmentum.rabbitmq.publishsubscribe;

import com.augmentum.Constants;
import com.augmentum.rabbitmq.Utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EmitLogHeader {

    private static final String EXCHANGE_NAME = "header_test";

    public static void main(String[] args) throws Exception {


        // The API requires a routing key, but in fact if you are using a header exchange the
        // value of the routing key is not used in the routing. You can store information
        // for the receiver here as the routing key is still available in the received message.
        String routingKey = "ourTestRoutingKey";

        // Argument processing: the first arg is the message, the rest are
        // key value pairs for headers.
//        String message = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope\">\n" + "<soapenv:Header/>\n" + "<soapenv:Body>\n" + "  <p:greet xmlns:p=\"http://greet.service.kishanthan.org\">\n" + "     <in>" + "------ZACK----" + "</in>\n" + "  </p:greet>\n" + "</soapenv:Body>\n" + "</soapenv:Envelope>";
String message ="sa";
        // The map for the headers.
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("SOAP_ACTION", "greet");

        // The rest of the arguments are key value header pairs.  For the purpose of this
        // example, we are assuming they are all strings, but that is not required by RabbitMQ

        Connection connection = ConnectionUtils.getConnection();

        try (Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.HEADERS);

            String replyQueueName = channel.queueDeclare(Constants.SIMPLE_QUEUE_NAME, false, false, false, null).getQueue();
            AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();

//            builder.messageId(messageID);
            builder.contentType("text/xml");
            builder.replyTo(replyQueueName);
            builder.correlationId(UUID.randomUUID().toString());
            builder.contentEncoding("UTF-8");

            // MessageProperties.PERSISTENT_TEXT_PLAIN is a static instance of AMQP.BasicProperties
            // that contains a delivery mode and a priority. So we pass them to the builder.
            builder.deliveryMode(MessageProperties.PERSISTENT_TEXT_PLAIN.getDeliveryMode());
            builder.priority(MessageProperties.PERSISTENT_TEXT_PLAIN.getPriority());

            // Add the headers to the builder.
            builder.headers(headers);

            // Use the builder to create the BasicProperties object.
            AMQP.BasicProperties theProps = builder.build();

            // Now we add the headers.  This example only uses string headers, but they can also be integers
            channel.basicPublish(EXCHANGE_NAME, routingKey, theProps, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent message: '" + message + "'");
        }
    }
}

