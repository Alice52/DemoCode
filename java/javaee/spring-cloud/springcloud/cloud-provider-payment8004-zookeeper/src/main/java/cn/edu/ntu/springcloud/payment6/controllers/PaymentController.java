package cn.edu.ntu.springcloud.payment4.controllers;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zack <br>
 * @create 2020-03-30 21:15 <br>
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

  @Value("${server.port}")
  private String port;

  @GetMapping(value = "/zookeeper")
  public JsonResult paymentZK() {

    return new JsonResult(
        200,
        "spring cloud integration zookeeper: port: "
            + port
            + " random id: "
            + UUID.randomUUID().toString(),
        null);
  }
}
