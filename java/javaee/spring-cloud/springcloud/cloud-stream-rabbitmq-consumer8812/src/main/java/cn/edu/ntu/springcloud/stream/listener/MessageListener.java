package cn.edu.ntu.springcloud.stream.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author zack <br>
 * @create 2020-04-11 22:23 <br>
 */
@EnableBinding(Sink.class)
@Slf4j
public class MessageListener {

  @Value("${server.port}")
  private String port;

  @StreamListener(Sink.INPUT)
  public void receive(Message<?> message) {
    log.info("consumer02 receive message: {}, and port: {}", message.getPayload(), port);
  }
}
