package cn.edu.ntu.springcloud.order6.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

    private static final String PAYMENT_URL = "http://cloud-payment-service-consul";

    @Resource private RestTemplate restTemplate;

    @GetMapping(value = "/consul")
    public JsonResult getPaymentById() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", JsonResult.class);
    }
}
