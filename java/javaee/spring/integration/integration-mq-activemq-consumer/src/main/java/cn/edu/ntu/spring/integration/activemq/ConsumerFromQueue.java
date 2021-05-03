package cn.edu.ntu.spring.integration.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zack
 * @create 2019-10-04 21:49
 * @function
 */
@Service
public class ConsumerFromQueue {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFromQueue.class);

    @Resource private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ConsumerFromQueue consumer =
                (ConsumerFromQueue) applicationContext.getBean("consumerFromQueue");
        // just get one message from queue
        String value = (String) consumer.jmsTemplate.receiveAndConvert();

        LOGGER.info("Consume text message: {} success!", value);
    }
}
