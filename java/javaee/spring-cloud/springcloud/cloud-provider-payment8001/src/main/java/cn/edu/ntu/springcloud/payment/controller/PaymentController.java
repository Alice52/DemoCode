package cn.edu.ntu.springcloud.payment.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.common.entities.Payment;
import cn.edu.ntu.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-03-10 00:52 <br>
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

  @Resource private PaymentService paymentService;

  @PostMapping(value = "/create")
  public JsonResult create(@RequestBody Payment payment) {

    int result = paymentService.create(payment);
    log.info("Create: {}", result);

    return result > 0
        ? new JsonResult<>(200, "success", result)
        : new JsonResult(999, "failed", null);
  }

  @GetMapping(value = "/get/{id}")
  public JsonResult getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("Query: {}", payment);
    ClassLoader.getSystemClassLoader().
            setDefaultAssertionStatus(true);

    return payment == null
        ? new JsonResult(999, "failed", null)
        : new JsonResult(200, "success", payment);
  }
}
