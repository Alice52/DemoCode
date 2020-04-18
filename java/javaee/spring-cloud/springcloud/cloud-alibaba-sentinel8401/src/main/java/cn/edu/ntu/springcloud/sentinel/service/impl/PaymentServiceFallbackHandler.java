package cn.edu.ntu.springcloud.sentinel.service.impl;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.sentinel.service.IPaymentService;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-04-18 13:03 <br>
 */
@Component
public class PaymentServiceFallbackHandler implements IPaymentService {

  @Override
  public JsonResult getPaymentById(Long id) {
    return new JsonResult(400, "PaymentServiceFallbackHandler");
  }
}
