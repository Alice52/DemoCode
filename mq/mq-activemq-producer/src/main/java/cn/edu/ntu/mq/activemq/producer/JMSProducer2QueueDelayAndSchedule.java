package cn.edu.ntu.mq.activemq.producer;

import cn.edu.ntu.mq.activemq.producer.utils.ActiveMQUtil;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;
import org.apache.activemq.ScheduledMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.util.UUID;

import static cn.edu.ntu.mq.constants.Constants.QUEUE_NAME;

/**
 * @author zack
 * @create 2019-10-26 22:01
 * @function
 */
public class JMSProducer2QueueDelayAndSchedule {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(JMSProducer2QueueDelayAndSchedule.class);

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
        // delay and schedule send
        long delay = 3 * 1000; // delay time
        long period = 4; // time interval
        int repeat = 5; // send time

        // 4. create message and send
        for (int i = 0; i < 4; i++) {
            TextMessage textMessage = session.createTextMessage("p2p message: " + i);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
            textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat);
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
