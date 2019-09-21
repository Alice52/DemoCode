package com.augmentum.mq.activemq;

import com.augmentum.mq.activemq.utils.ActiveMQUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Optional;

import static com.augmentum.mq.activemq.Constants.TOPIC_NAME;

/**
 * @author zack
 * @create 2019-10-04 16:02
 * @function
 */
public class JMSConsumerFromTopic {
  private static final Logger LOGGER = LoggerFactory.getLogger(JMSConsumerFromTopic.class);

  public static void main(String[] args) throws JMSException, IOException {
    // 1. create session
    Connection connection = ActiveMQUtil.getConnection();
    connection.start();
    // if the arg of transacted is true, should be commit.
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    // 2. create destination
    Topic topic = session.createTopic(TOPIC_NAME);
    // 3. create producer
    MessageConsumer consumer = session.createConsumer(topic);

    // 4.2 consume message: async
    consumer.setMessageListener(JMSConsumerFromTopic::onMessage);

    System.in.read();
    // 5. close resource
    consumer.close();
    session.close();
    connection.close();
  }

  private static void onMessage(Message message) {
    Optional.ofNullable(message)
        .ifPresent(
            mg -> {
              MapMessage mapMessage = (MapMessage) message;
              try {
                LOGGER.info("Success consume map message: {}. To service: {}", mapMessage.getString("k1"), mapMessage.getStringProperty("SERVICE"));
              } catch (JMSException e) {
                LOGGER.warn(
                    "Failed to consume map message {}, the cause is below: {}", mapMessage, e);
              }
            });
  }
}
