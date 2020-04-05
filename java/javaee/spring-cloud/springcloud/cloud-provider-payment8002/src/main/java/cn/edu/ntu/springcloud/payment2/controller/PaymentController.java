package cn.edu.ntu.springcloud.payment2.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.common.entities.Payment;
import cn.edu.ntu.springcloud.payment2.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2020-03-10 00:52 <br>
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

  @Value("${server.port}")
  private String port;

  @Resource private PaymentService paymentService;

  @PostMapping(value = "/create")
  public JsonResult create(@RequestBody Payment payment) {

    int result = paymentService.create(payment);
    log.info("Create: {}", result);

    return result > 0
        ? new JsonResult<>(200, "success, and port: " + port, result)
        : new JsonResult(999, "failed", null);
  }

  @GetMapping(value = "/get/{id}")
  public JsonResult getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("Query: {}", payment);
    ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);

    return payment == null
        ? new JsonResult(999, "failed", null)
        : new JsonResult(200, "success, and port: " + port, payment);
  }

  @GetMapping(value = "/lb")
  public JsonResult getPaymentLB() {

    return new JsonResult(200, port);
  }

  @GetMapping(value = "/feign/timeout")
  public JsonResult paymentTimeout() throws InterruptedException {

    TimeUnit.SECONDS.sleep(5);
    return new JsonResult(200, port);
  }
}
