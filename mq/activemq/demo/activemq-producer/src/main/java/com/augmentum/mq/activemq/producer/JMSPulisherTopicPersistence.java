package com.augmentum.mq.activemq.producer;

import com.augmentum.mq.activemq.utils.ActiveMQUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

import java.util.UUID;

import static com.augmentum.mq.activemq.Constants.TOPIC_NAME;

/**
 * @author zack
 * @create 2019-10-04 17:40
 * @function
 */
public class JMSPulisherTopicPersistence {

  private static final Logger LOGGER = LoggerFactory.getLogger(JMSPulisherTopicPersistence.class);

  public static void main(String[] args) throws JMSException {
    // 1. create session
    Connection connection = ActiveMQUtil.getConnection();
    // if the arg of transacted is true, should be commit.
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    // 2. create destination
    Topic topic = session.createTopic(TOPIC_NAME);
    // 3. create producer
    MessageProducer producer = session.createProducer(topic);
    // notice this change: in case of 'PERSISTENT'
    producer.setDeliveryMode(DeliveryMode.PERSISTENT);
    connection.start();
    // 4. create message and send
    for (int i = 0; i < 4; i++) {
      MapMessage message = session.createMapMessage();
      message.setString("k1", "v1");
      message.setJMSMessageID(UUID.randomUUID().toString());
      message.setStringProperty("SERVICE", "UserService");
      message.setStringProperty("ACTION", "getUserById");
      producer.send(message);
      LOGGER.info("Send message {} success.", message);
    }
    // 5. close resource
    producer.close();
    connection.close();
    ActiveMQUtil.getSession(session);
  }
}
