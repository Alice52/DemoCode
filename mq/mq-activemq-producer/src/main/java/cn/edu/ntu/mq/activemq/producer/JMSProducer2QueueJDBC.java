package cn.edu.ntu.mq.activemq.producer;

import cn.edu.ntu.mq.activemq.producer.utils.ActiveMQUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

import static cn.edu.ntu.mq.constants.Constants.QUEUE_NAME;

/**
 * @author zack
 * @create 2019-10-26 19:18
 * @function
 */
public class JMSProducer2QueueJDBC {

  private static final Logger LOGGER = LoggerFactory.getLogger(JMSProducer2QueueJDBC.class);

  public static void main(String[] args) throws JMSException {
    // 1. create session
    Connection connection = ActiveMQUtil.getConnection();
    // if the arg of transacted is true, should be commit.
    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    // 2. create destination
    Queue queue = session.createQueue(QUEUE_NAME);
    // 3. create producer
    MessageProducer producer = session.createProducer(queue);
    // use jdbc durable in mysql, should enable PERSISTENT
    producer.setDeliveryMode(DeliveryMode.PERSISTENT);

    // 4. create message and send
    for (int i = 0; i < 4; i++) {
      TextMessage textMessage = session.createTextMessage("p2p message and jdbc durable: " + i);
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
