package cn.edu.ntu.springcloud.alibaba.order.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-04-12 14:05 <br>
 */
@RestController
@RequestMapping(value = "/consumer")
public class OrderController {

  @Resource private RestTemplate restTemplate;

  @Value("${service-url.nacos-payment-service}")
  private String PROVIDER_URL;

  @GetMapping(value = "/payment/get/{id}")
  public JsonResult getPaymentById(@PathVariable("id") Long id) {
    return restTemplate.getForObject(PROVIDER_URL + "/payment/nacos/get/" + id, JsonResult.class);
  }
}
