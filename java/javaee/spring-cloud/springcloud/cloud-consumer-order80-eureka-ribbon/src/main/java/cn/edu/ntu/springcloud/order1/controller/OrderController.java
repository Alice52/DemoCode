package cn.edu.ntu.springcloud.order1.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT-SERVICE";

    @Resource private RestTemplate restTemplate;

    @GetMapping(value = "/payment/create")
    public JsonResult<Payment> create(Payment payment) {

        return restTemplate.postForObject(
                PAYMENT_URL + "/payment/create", payment, JsonResult.class);
    }

    @GetMapping(value = "/payment/get/{id}")
    public JsonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, JsonResult.class);
    }

    @GetMapping(value = "/payment/getEntity/{id}")
    public JsonResult getPaymentById2(@PathVariable("id") Long id) {
        return new JsonResult(
                200,
                "ok",
                restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, JsonResult.class));
    }
}
