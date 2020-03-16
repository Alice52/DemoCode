package cn.edu.ntu.springcloud.order.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-03-10 21:42 <br>
 */
@RestController
@Slf4j
@RequestMapping(value = "/consumer")
public class OrderController {

  private static final String PAYMENT_URL = "http://localhost:8001";

  @Resource private RestTemplate restTemplate;

  @GetMapping(value = "/payment/create")
  public JsonResult<Payment> create(Payment payment) {

    return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, JsonResult.class);
  }

  @GetMapping(value = "/payment/get/{id}")
  public JsonResult getPaymentById(@PathVariable("id") Long id) {
    return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, JsonResult.class);
  }
}
