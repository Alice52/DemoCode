//package com.augmentum.rabbitmq.esb;
//
//import com.augmentum.Constants;
//import com.augmentum.rabbitmq.Utils.ConnectionUtils;
//import com.rabbitmq.client.AMQP;
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author zack
// * @create 2019-07-28 21:12
// * @function
// */
//public class Sender {
//    private static Connection connection = ConnectionUtils.getConnection();
//
//    public static void main(String[] args) throws IOException {
//
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(Constants.WORK_QUEUE_NAME, false, false, false, null);
//        //                channel.exchangeDeclare(exchangeName, "direct", true);
//        channel.queueBind(Constants.WORK_QUEUE_NAME, "", null);
//
//        // The message to be sent
//        String message = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope\">\n" + "<soapenv:Header/>\n" + "<soapenv:Body>\n" + "  <p:greet xmlns:p=\"http://greet.service.kishanthan.org\">\n" + "     <in>" + "zack" + "</in>\n" + "  </p:greet>\n" + "</soapenv:Body>\n" + "</soapenv:Envelope>";
//
//        // Populate the AMQP message properties
//        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties().builder();
//        builder.messageId(messageID);
//        builder.contentType("text/xml");
//        builder.replyTo(replyToAddress);
//        builder.correlationId(correlationId);
//        builder.contentEncoding(contentEncoding);
//
//        // Custom user properties
//        Map<String, Object> headers = new HashMap<String, Object>();
//        headers.put("SOAP_ACTION", "greet");
//        builder.headers(headers);
//
//        // Publish the message to exchange
//        channel.basicPublish(exchangeName, queueName, builder.build(), message.getBytes());
//    }
//}
