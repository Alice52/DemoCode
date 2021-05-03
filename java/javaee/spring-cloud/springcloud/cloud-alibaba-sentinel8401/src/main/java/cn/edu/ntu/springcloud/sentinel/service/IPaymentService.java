package cn.edu.ntu.springcloud.sentinel.service;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.sentinel.service.impl.PaymentServiceFallbackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zack <br>
 * @create 2020-04-18 12:57 <br>
 */
@FeignClient(
        value = "${service-url.nacos-payment-service}",
        fallback = PaymentServiceFallbackHandler.class)
public interface IPaymentService {

    @GetMapping(value = "/payment/nacos/get/{id}")
    public JsonResult getPaymentById(@PathVariable("id") Long id);
}
