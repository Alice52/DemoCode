package cn.edu.ntu.javaee.boot.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-07-27 20:29 <br>
 * @project springboot <br>
 */
@Component
public class Consumer implements CommandLineRunner {

  @Value("${apache.rocketmq.consumer.pushConsumer}")
  private String pushConsumer;
  @Value("${apache.rocketmq.namesrvAddr}")
  private String namesrvAddr;

  public void messageListener() {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(pushConsumer);
    consumer.setNamesrvAddr(namesrvAddr);
    try {

      // subscribe PushTopic topic and tag is push messages
      consumer.subscribe("PushTopic", "push");

      // 程序第一次启动从消息队列头获取数据
      consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
      // 可以修改每次消费消息的数量，默认设置是每次消费一条
      consumer.setConsumeMessageBatchMaxSize(1);

      // 在此监听中消费信息，并返回消费的状态信息
      consumer.registerMessageListener(
          (MessageListenerConcurrently)
              (msgs, context) -> {
                // 会把不同的消息分别放置到不同的队列中
                for (Message msg : msgs) {

                  System.out.println("接收到了消息：" + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
              });

      consumer.start();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run(String... args) throws Exception {
    this.messageListener();
  }
}
