package cn.edu.ntu.integration.activemqsender;

import cn.edu.ntu.integration.activemqsender.sender.Sender2Queue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ActivemqSenderApplication.class)
@WebAppConfiguration
public class ActivemqSenderApplicationTests {

    @Autowired private Sender2Queue sender2Queue;

    @Test
    public void testSender() {
        sender2Queue.sendMessage2Queue();
    }
}
