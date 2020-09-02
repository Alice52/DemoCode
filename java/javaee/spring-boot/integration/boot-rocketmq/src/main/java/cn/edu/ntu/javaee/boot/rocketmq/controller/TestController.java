package cn.edu.ntu.javaee.boot.rocketmq.controller;

import cn.edu.ntu.javaee.boot.rocketmq.producer.Producer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @author zack <br>
 * @create 2020-07-27 20:31 <br>
 * @project springboot <br>
 */
@RestController
public class TestController {
  @Autowired private Producer producer;

  @RequestMapping("/push")
  public String pushMsg() {
    try {

      return producer.send("PushTopic", "push", "hello rocketmq");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (RemotingException e) {
      e.printStackTrace();
    } catch (MQClientException e) {
      e.printStackTrace();
    } catch (MQBrokerException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "ERROR";
  }
}
