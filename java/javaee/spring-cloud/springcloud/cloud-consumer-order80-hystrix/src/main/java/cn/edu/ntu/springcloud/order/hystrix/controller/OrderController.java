package cn.edu.ntu.springcloud.order.hystrix.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.order.hystrix.service.HystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-04-02 23:36 <br>
 */
@RestController
@RequestMapping(value = "/consumer")
public class OrderController {

  @Resource private HystrixService hystrixService;

  @GetMapping("/hystrix/success-info")
  public JsonResult getPaymentInfo() {
    return hystrixService.getPaymentInfos();
  }

  @GetMapping("/hystrix/fail-info")
  public JsonResult getPaymentInfoTimeout() {
    return hystrixService.getPaymentInfoTimeout();
  }
}
