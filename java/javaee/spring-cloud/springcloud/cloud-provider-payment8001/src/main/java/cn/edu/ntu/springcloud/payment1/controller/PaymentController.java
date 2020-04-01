package cn.edu.ntu.springcloud.payment1.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.common.entities.Payment;
import cn.edu.ntu.springcloud.payment1.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

  @Value("${server.port}")
  private String port;

  @Resource private PaymentService paymentService;

  @Resource private DiscoveryClient discoveryClient;

  @PostMapping(value = "/create")
  public JsonResult create(@RequestBody Payment payment) {

    int result = paymentService.create(payment);
    log.info("Create: {}", result);

    return result > 0
        ? new JsonResult<>(200, "success, and port: " + port, result)
        : new JsonResult(999, "failed", null);
  }

  @GetMapping(value = "/get/{id}")
  public JsonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("Query: {}", payment);
    ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);

    return payment == null
        ? new JsonResult(999, "failed", null)
        : new JsonResult(200, "success, and port: " + port, payment);
  }

  @GetMapping(value = "/discovery")
  public Object discovery() {

    discoveryClient.getServices().stream().forEach(x -> log.info(x));
    discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE").stream()
        .forEach(
            x ->
                log.info(
                    x.getServiceId()
                        + ", host"
                        + x.getHost()
                        + ", port: "
                        + x.getPort()
                        + ", uri: "
                        + x.getUri()));

    return this.discoveryClient;
  }

  @GetMapping(value = "/lb")
  public JsonResult getPaymentLB() {

    return new JsonResult(200, port);
  }
}
