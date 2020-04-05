package cn.edu.ntu.springcloud.order.feign.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.order.feign.service.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-04-02 20:39 <br>
 */
@RestController
@RequestMapping(value = "/consumer")
public class OrderController {

    @Resource private FeignService feignService;


    @GetMapping(value = "/payment/get/{id}")
    public JsonResult getPaymentById(@PathVariable("id") Long id) {
        return feignService.getPaymentById(id);
    }

    @GetMapping(value = "/payment/feign/timeout")
    public JsonResult getPaymentByIdTimeout() {
        return feignService.paymentTimeout();
    }
}
