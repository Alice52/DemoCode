package cn.edu.ntu.springcloud.alibaba.payment.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zack <br>
 * @create 2020-04-12 13:49 <br>
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

  @Value("${server.port}")
  private String port;

  @GetMapping(value = "/nacos/get/{id}")
  public JsonResult getPaymentById(@PathVariable("id") Long id) {

    return new JsonResult(200, "success, and port: " + port, id);
  }
}
