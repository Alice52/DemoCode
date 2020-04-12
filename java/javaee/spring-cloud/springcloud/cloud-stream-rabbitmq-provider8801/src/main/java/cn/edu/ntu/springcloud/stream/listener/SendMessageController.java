package cn.edu.ntu.springcloud.stream.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.stream.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-04-11 21:52 <br>
 */
@RestController
@RequestMapping(value = "/message")
public class SendMessageController {

  @Resource private IMessageProvider messageProvider;

  @GetMapping(value = "/send")
  public JsonResult sendMessage() {

    Object sendData = messageProvider.send();
    return new JsonResult(200, "send message success", sendData);
  }
}
