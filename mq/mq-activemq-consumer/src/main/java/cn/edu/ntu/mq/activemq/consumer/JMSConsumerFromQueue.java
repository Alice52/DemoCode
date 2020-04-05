package cn.edu.ntu.mq.activemq.consumer;

import cn.edu.ntu.mq.activemq.utils.ActiveMQUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Optional;

import static cn.edu.ntu.mq.constants.Constants.QUEUE_NAME;

/**
 * @author zack
 * @create 2019-10-04 12:58
 * @function
 */
public class JMSConsumerFromQueue {
  private static final Logger LOGGER = LoggerFactory.getLogger(JMSConsumerFromQueue.class);

  public static void main(String[] args) throws JMSException, IOException {
    // 1. create session
    Connection connection = ActiveMQUtil.getConnection();
    connection.start();
    // if the arg of transacted is true, should be commit.
    Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
    // 2. create destination
    Queue queue = session.createQueue(QUEUE_NAME);
    // 3. create producer
    MessageConsumer consumer = session.createConsumer(queue);

    // 4.1 consume message: sync
    //    while (true) {
    //      TextMessage message = (TextMessage) consumer.receive(4000L);
    //      boolean present = Optional.ofNullable(message).isPresent();
    //      if (present == true) LOGGER.info("Consume message {} success.", message.getText());
    //      else break;
    //    }
    // 4.2 consume message: async
    consumer.setMessageListener(JMSConsumerFromQueue::onMessage);

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
              TextMessage textMessage = (TextMessage) mg;
              try {
                LOGGER.info("Consume message {} success.", textMessage.getText());
                textMessage.acknowledge();
              } catch (JMSException e) {
                LOGGER.warn("Failed to consume message {}, the cause is below: {}", textMessage, e);
              }
            });
  }
}
