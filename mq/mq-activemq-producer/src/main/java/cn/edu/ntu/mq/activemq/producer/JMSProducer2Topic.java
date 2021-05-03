package cn.edu.ntu.mq.activemq.producer;

import cn.edu.ntu.mq.activemq.producer.utils.ActiveMQUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.util.UUID;

import static cn.edu.ntu.mq.constants.Constants.TOPIC_NAME;

/**
 * @author zack
 * @create 2019-10-04 15:57
 * @function
 */
public class JMSProducer2Topic {

    private static final Logger LOGGER = LoggerFactory.getLogger(JMSProducer2Topic.class);

    public static void main(String[] args) throws JMSException {
        // 1. create session
        Connection connection = ActiveMQUtil.getConnection();
        connection.start();
        // if the arg of transacted is true, should be commit.
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 2. create destination
        Topic topic = session.createTopic(TOPIC_NAME);
        // 3. create producer
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        // 4. create message and send
        for (int i = 0; i < 4; i++) {
            MapMessage message = session.createMapMessage();
            message.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
            message.setString("k1", "v1");
            message.setJMSMessageID(UUID.randomUUID().toString());
            message.setStringProperty("SERVICE", "UserService");
            producer.send(message);
            LOGGER.info("Send message {} success.", message);
        }
        // 5. close resource
        producer.close();
        session.commit();
        session.close();
        connection.close();
        ActiveMQUtil.getSession(session);
    }
}
