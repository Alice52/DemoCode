package cn.edu.ntu.springcloud.stream.service.impl;

import cn.edu.ntu.springcloud.stream.service.IMessageProvider;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * this service is work with mq, so donot need @Service annotation.<br>
 * @EnableBinding(Source.class) is to define message push Channel<br>
 *
 * @author zack <br>
 * @create 2020-04-11 21:36 <br>
 */
@Slf4j
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

  /** message push channel */
  @Resource private MessageChannel output;

  @Override
  public Object send() {
    String serial = IdUtil.simpleUUID();
    output.send(MessageBuilder.withPayload(serial).build());
    log.info("send message success: {}", serial);

    return serial;
  }
}
