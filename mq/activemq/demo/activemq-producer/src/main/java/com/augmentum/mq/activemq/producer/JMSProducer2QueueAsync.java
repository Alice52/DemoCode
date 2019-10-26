package com.augmentum.mq.activemq.producer;

import com.augmentum.mq.activemq.utils.ActiveMQUtil;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

import java.util.UUID;

import static com.augmentum.mq.activemq.Constants.QUEUE_NAME;

/**
 * @author zack
 * @create 2019-10-26 20:56
 * @function
 */
public class JMSProducer2QueueAsync {
  private static final Logger LOGGER = LoggerFactory.getLogger(JMSProducer2QueueAsync.class);

  public static void main(String[] args) throws JMSException {
    // 1. create session
    ActiveMQConnection connection = (ActiveMQConnection) ActiveMQUtil.getConnection();
    connection.setUseAsyncSend(true); // set async send
    // if the arg of transacted is true, should be commit.
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    // 2. create destination
    Queue queue = session.createQueue(QUEUE_NAME);
    // 3. create producer
    ActiveMQMessageProducer producer = (ActiveMQMessageProducer) session.createProducer(queue);
    producer.setDeliveryMode(DeliveryMode.PERSISTENT);

    // 4. create message and send
    for (int i = 0; i < 4; i++) {
      TextMessage textMessage = session.createTextMessage("p2p message: " + i);
      String messageID = UUID.randomUUID().toString();
      textMessage.setJMSMessageID(messageID);
      producer.send(
          textMessage,
          new AsyncCallback() {
            @Override
            public void onSuccess() {
              LOGGER.info(
                  "producer: {} send message[{}]: {} to queue: {} success.",
                  producer,
                  messageID,
                  textMessage,
                  QUEUE_NAME);
            }

            @Override
            public void onException(JMSException exception) {
              LOGGER.error(
                  "producer: {} send message[{}]: {} to queue: {} failed, exception info: {}",
                  producer,
                  messageID,
                  textMessage,
                  QUEUE_NAME,
                  exception);
            }
          });
    }
    // 5. close resource
    producer.close();
    connection.close();
    ActiveMQUtil.getSession(session);
  }
}
