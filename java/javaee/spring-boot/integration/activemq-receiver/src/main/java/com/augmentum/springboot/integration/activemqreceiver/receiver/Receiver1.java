package com.augmentum.springboot.integration.activemqreceiver.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author zack
 * @create 2019-10-05 18:40
 * @function
 *           false + destination = queue; will declare queue
 *           true + destination = queue; will declare topic
 */
@Component
public class Receiver1 {
  private static final Logger LOG = LoggerFactory.getLogger(Receiver1.class);

  @Value("${queue-name}")
  private String queueName;

  @Value("${queue-reply}")
  private String queueReply;

  @JmsListener(destination = "${queue-name}")
  // @SendTo("${queue-reply}")
  @SendTo("${topic-name}")  // false + destination = queue; will declare queue
  public String receiveFromQueue(TextMessage textMessage) {
    if (textMessage != null) {
      String message;
      try {
        message = textMessage.getText();
        LOG.info("Receive message: {} from queue: {} success.", message, queueName);
        return "reply message: " + textMessage.getText();
      } catch (JMSException e) {
        LOG.warn(
            "Failed to receive message: {} from queue: {}, cause by {}.",
            textMessage,
            queueName,
            e);
      }
    }
    return null;
  }
}
