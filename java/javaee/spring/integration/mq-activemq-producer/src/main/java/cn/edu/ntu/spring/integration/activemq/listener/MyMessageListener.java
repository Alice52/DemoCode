package cn.edu.ntu.spring.integration.activemq.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Optional;

/**
 * @author zack
 * @create 2019-10-04 22:16
 * @function Auto listener, do not need to start consumer.
 */
@Component
public class MyMessageListener implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyMessageListener.class);

    @Override
    public void onMessage(Message message) {
        Optional.ofNullable(message).ifPresent(mg-> {
            TextMessage textMessage = (TextMessage) mg;
            try {
                String text = textMessage.getText();
                LOGGER.info("Consume text message: {} success.", text);
            } catch (JMSException jmsException) {
                LOGGER.info("Failed to consume text message: {}, cause by {}.", textMessage, jmsException);
            }
        });
    }
}
