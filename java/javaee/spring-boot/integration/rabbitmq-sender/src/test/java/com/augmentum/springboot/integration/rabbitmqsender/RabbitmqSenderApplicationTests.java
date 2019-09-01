package com.augmentum.springboot.integration.rabbitmqsender;

import com.augmentum.springboot.integration.rabbitmqsender.direct.DirectSender;
import com.augmentum.springboot.integration.rabbitmqsender.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqSenderApplication.class)
@WebAppConfiguration
public class RabbitmqSenderApplicationTests {

  @Autowired DirectSender directSender;
  @Autowired TopicSender topicSender;

  @Test
  public void testDirectSender() {
    directSender.directSender();
  }

  @Test
  public void testTopic() {
    topicSender.topicSender();
  }
}
