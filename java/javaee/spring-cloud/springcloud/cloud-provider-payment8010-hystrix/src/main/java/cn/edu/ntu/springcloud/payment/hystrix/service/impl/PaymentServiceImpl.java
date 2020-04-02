package cn.edu.ntu.springcloud.payment.hystrix.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cn.edu.ntu.springcloud.payment.hystrix.service.PaymentService;

import java.util.concurrent.TimeUnit;

/**
 * @author zack <br>
 * @create 2020-04-02 22:31 <br>
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

  @Override
  public String getPaymentInfo(String id) {
    String message =
        "Thread Pool: "
            + Thread.currentThread().getName()
            + ",call getPaymentInfo("
            + id
            + "): success";
    log.warn(message);
    return message;
  }

  @Override
  public String getPaymentInfoTimeout(String id) throws InterruptedException {
    TimeUnit.SECONDS.sleep(5);
    String message =
        "Thread Pool: "
            + Thread.currentThread().getName()
            + ",call getPaymentInfoTimeout("
            + id
            + "): success";
    log.warn(message);

    return message;
  }
}
