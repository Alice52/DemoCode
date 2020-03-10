package cn.edu.ntu.springcloud.payment.controller;

import cn.edu.ntu.springcloud.payment.entities.JsonResult;
import cn.edu.ntu.springcloud.payment.entities.Payment;
import cn.edu.ntu.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-03-10 00:52 <br>
 */
@RestController
@Slf4j
public class PaymentController {

  @Resource private PaymentService paymentService;

  @PostMapping(value = "/payment/create")
  public JsonResult create(Payment payment) {

    var result = paymentService.create(payment);
    log.info("Create: {}", result);

    return result > 0
        ? new JsonResult<>(200, "success", result)
        : new JsonResult(999, "failed", null);
  }

  @GetMapping(value = "/payment/get/{id}")
  public JsonResult getPaymentById(@PathVariable("id") Long id) {

    Payment payment = paymentService.getPaymentById(id);
    log.info("Query: {}", payment);

    return payment == null
        ? new JsonResult(999, "failed", null)
        : new JsonResult(200, "success", payment);
  }
}
