package cn.edu.ntu.springcloud.payment.hystrix.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.payment.hystrix.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-04-02 22:40 <br>
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hystrix/success-info")
    public JsonResult getPaymentInfo() {
        return new JsonResult(200, "port: " + port, paymentService.getPaymentInfo(port));
    }

    @GetMapping("/hystrix/fail-info")
    public JsonResult getPaymentInfoTimeout() throws InterruptedException {
        return new JsonResult(200, "port: " + port, paymentService.getPaymentInfoTimeout(port));
    }

    @GetMapping("/hystrix/circuit-breaker/{id}")
    public JsonResult paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return new JsonResult(200, "port: " + port, paymentService.paymentCircuitBreaker(id));
    }
}
