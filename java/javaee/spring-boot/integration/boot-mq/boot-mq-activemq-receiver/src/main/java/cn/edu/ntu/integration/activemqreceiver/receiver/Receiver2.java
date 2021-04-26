package cn.edu.ntu.integration.activemqreceiver.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Optional;

/**
 * @author zack
 * @create 2019-10-05 19:01
 * @function false + destination = queue; will declare queue true + destination = queue; will
 *     declare topic
 */
@Component
public class Receiver2 {
  private static final Logger LOG = LoggerFactory.getLogger(Receiver2.class);

  @Value("${topic-name}")
  private String topicName;

  // destination is super class of queue and topic
  @JmsListener(destination = "${topic-name}")
  public void receiveFromTopic(TextMessage textMessage) {
    Optional.ofNullable(textMessage)
        .ifPresent(
            mg -> {
              try {
                LOG.info(
                    "Receive message: {} from topic: {} success.",
                    textMessage.getText(),
                    topicName);
              } catch (JMSException e) {
                LOG.warn(
                    "Failed to receive message: {} from topic: {}, cause by {}.",
                    textMessage,
                    topicName,
                    e);
              }
            });
  }
}
