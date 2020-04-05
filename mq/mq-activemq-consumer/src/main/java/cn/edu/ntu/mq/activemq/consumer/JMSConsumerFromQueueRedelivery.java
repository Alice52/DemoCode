package cn.edu.ntu.mq.activemq.consumer;

import cn.edu.ntu.mq.constants.Constants;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

import java.io.IOException;
import java.util.Optional;

import static cn.edu.ntu.mq.constants.Constants.QUEUE_NAME;

/**
 * @author zack
 * @create 2019-10-26 22:46
 * @function
 */
public class JMSConsumerFromQueueRedelivery {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(JMSConsumerFromQueueRedelivery.class);

  public static void main(String[] args) throws JMSException, IOException {
    // 1. create session
    ActiveMQConnectionFactory activeMQConnectionFactory =
        new ActiveMQConnectionFactory(Constants.NIO_ACTIVEMQ_URL);

    RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
    queuePolicy.setInitialRedeliveryDelay(100);
    queuePolicy.setRedeliveryDelay(1000);
    queuePolicy.setMaximumRedeliveries(2);
    activeMQConnectionFactory.setRedeliveryPolicy(queuePolicy);

    Connection connection = activeMQConnectionFactory.createConnection();
    connection.start();
    // if the arg of transacted is true, should be commit.
    Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
    // 2. create destination
    Queue queue = session.createQueue(QUEUE_NAME);
    // 3. create producer
    MessageConsumer consumer = session.createConsumer(queue);

    // 4.2 consume message: async
    consumer.setMessageListener(JMSConsumerFromQueueRedelivery::onMessage);

    // session.commit();
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
                LOGGER.info(
                    "Consume message {} from queue {} success.", textMessage.getText(), QUEUE_NAME);
                textMessage.acknowledge();
              } catch (JMSException e) {
                LOGGER.warn("Failed to consume message {}, the cause is below: {}", textMessage, e);
              }
            });
  }
}
