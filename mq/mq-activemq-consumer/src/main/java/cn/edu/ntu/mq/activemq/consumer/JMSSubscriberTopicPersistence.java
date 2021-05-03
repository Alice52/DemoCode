package cn.edu.ntu.mq.activemq.consumer;

import cn.edu.ntu.mq.activemq.consumer.utils.ActiveMQUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import static cn.edu.ntu.mq.constants.Constants.TOPIC_NAME;

/**
 * @author zack
 * @create 2019-10-04 17:39
 * @function
 */
public class JMSSubscriberTopicPersistence {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(JMSSubscriberTopicPersistence.class);

    public static void main(String[] args) throws JMSException, IOException {
        // 1. create session
        Connection connection = ActiveMQUtil.getConnection();
        // notice: sub/pub case
        connection.setClientID("subscribe01");
        // if the arg of transacted is true, should be commit.
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 2. create destination
        Topic topic = session.createTopic(TOPIC_NAME);
        // 3. create producer
        MessageConsumer consumer = session.createConsumer(topic);
        TopicSubscriber topicSubscriber =
                session.createDurableSubscriber(topic, UUID.randomUUID().toString());
        connection.start();
        // 4.2 consume message: async
        topicSubscriber.setMessageListener(JMSSubscriberTopicPersistence::onMessage);

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
                                LOGGER.info(
                                        "Success consume map message: {}. To service: {}, action: {}.",
                                        mapMessage.getString("k1"),
                                        mapMessage.getStringProperty("SERVICE"),
                                        mapMessage.getStringProperty("ACTION"));
                            } catch (JMSException e) {
                                LOGGER.warn(
                                        "Failed to consume map message {}, the cause is below: {}",
                                        mapMessage,
                                        e);
                            }
                        });
    }
}
