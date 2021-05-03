package cn.edu.ntu.springcloud.order.feign.service;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.common.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zack <br>
 * @create 2020-04-02 20:26 <br>
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-SERVICE")
public interface FeignService {

    /**
     * this implement service call provider service, omit rest-template. <br>
     * the annotation point out api, and which must be same as provider controller.<br>
     * the method name donot important, it can be changed as you like.<br>
     *
     * @param id which must be same as provider controller parameter and modifier
     * @return JsonResult<Payment> it is provider service expose interface by controller <br>
     */
    @GetMapping(value = "/payment/get/{id}")
    JsonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * this is mock timeout between service call<br>
     *
     * @return JsonResult
     */
    @GetMapping(value = "/payment/feign/timeout")
    JsonResult paymentTimeout();
}
