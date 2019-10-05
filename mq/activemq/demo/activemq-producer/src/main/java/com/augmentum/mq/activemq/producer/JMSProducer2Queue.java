package com.augmentum.mq.activemq.producer;

import com.augmentum.mq.activemq.utils.ActiveMQUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * @author zack
 * @create 2019-10-03 10:50
 * @function This class is message producer.
 */
public class JMSProducer2Queue {
  private static final Logger LOGGER = LoggerFactory.getLogger(JMSProducer2Queue.class);
  private static final String QUEUE_NAME = "p2p_queue";

  public static void main(String[] args) throws JMSException {
    // 1. create session
    Connection connection = ActiveMQUtil.getConnection();
    // if the arg of transacted is true, should be commit.
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    // 2. create destination
    Queue queue = session.createQueue(QUEUE_NAME);
    // 3. create producer
    MessageProducer producer = session.createProducer(queue);
    producer.setDeliveryMode(DeliveryMode.PERSISTENT);

    // 4. create message and send
    for (int i = 0; i < 4; i++) {
      TextMessage textMessage = session.createTextMessage("p2p message: " + i);
      textMessage.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
      producer.send(textMessage);
      LOGGER.info("Send message {} success.", textMessage);
    }
    // 5. close resource
    producer.close();
    connection.close();
    ActiveMQUtil.getSession(session);
  }
}
