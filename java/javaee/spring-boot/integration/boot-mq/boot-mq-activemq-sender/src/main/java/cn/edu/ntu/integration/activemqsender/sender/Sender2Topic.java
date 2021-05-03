package cn.edu.ntu.integration.activemqsender.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

/**
 * @author zack
 * @create 2019-10-05 18:57
 * @function
 */
@Component
public class Sender2Topic {
    private static final Logger LOG = LoggerFactory.getLogger(Sender2Topic.class);

    @Autowired private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired private Topic topic;

    public void sendMessage2Topic() {
        String message = UUID.randomUUID().toString();
        jmsMessagingTemplate.convertAndSend(topic, message);
        LOG.info("Send message: {} success.", message);
    }

    //    @Scheduled(fixedDelay = 3000)
    public void sendMessage2TopicSchedule() {
        sendMessage2Topic();
    }
}
