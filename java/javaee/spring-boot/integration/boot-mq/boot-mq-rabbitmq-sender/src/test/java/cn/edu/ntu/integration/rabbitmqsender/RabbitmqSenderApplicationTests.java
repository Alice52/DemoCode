package cn.edu.ntu.integration.rabbitmqsender;

import cn.edu.ntu.integration.rabbitmqsender.direct.DirectSender;
import cn.edu.ntu.integration.rabbitmqsender.topic.TopicSender;
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
