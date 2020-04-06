package cn.edu.ntu.springcloud.feign.hystrix.service;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zack <br>
 * @create 2020-04-02 23:38 <br>
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX", fallback = HystrixServiceHandler.class)
public interface HystrixService {

  /**
   * this is just mock success api.<br>
   *
   * @return JsonResult
   */
  @GetMapping("/payment/hystrix/success-info")
  JsonResult getPaymentInfos();

  /**
   * this is just mock timeout error api.<br>
   *
   * @return JsonResult
   */
  @GetMapping("/payment/hystrix/fail-info")
  JsonResult getPaymentInfoTimeout();

  /**
   * this is just mock timeout error api.<br>
   *
   * @return JsonResult
   */
  @GetMapping("/payment/hystrix/error-info")
  JsonResult getPaymentInfoError();
}
