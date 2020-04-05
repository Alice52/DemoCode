package cn.edu.ntu.integration.activemqsender.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @author zack
 * @create 2019-10-05 18:14
 * @function
 */
@Component
public class Sender2Queue {
  private static final Logger LOG = LoggerFactory.getLogger(Sender2Queue.class);

  @Autowired private JmsMessagingTemplate jmsMessagingTemplate;

  @Autowired private Queue queue;

  public void sendMessage2Queue() {
    String message = UUID.randomUUID().toString();
    jmsMessagingTemplate.convertAndSend(queue, message);
    LOG.info("Send message: {} success.", message);
  }

  @Scheduled(fixedDelay = 3000)
  public void sendMessage2QueueSchedule() {
    sendMessage2Queue();
  }
}
