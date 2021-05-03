package cn.edu.ntu.springcloud.payment.hystrix.service.impl;

import cn.edu.ntu.springcloud.payment.hystrix.service.PaymentService;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreakerHandler",
            commandProperties = {
                @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                @HystrixProperty(
                        name = "circuitBreaker.sleepWindowInMilliseconds",
                        value = "10000"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            })
    public String paymentCircuitBreaker(Integer id) {

        if (id < 0) {
            throw new RuntimeException();
        }

        String message =
                "Thread Pool: "
                        + Thread.currentThread().getName()
                        + ",call getPaymentInfoTimeout("
                        + id
                        + ") success: "
                        + IdUtil.simpleUUID();
        log.warn(message);

        return message;
    }

    public String paymentCircuitBreakerHandler(Integer id) {

        return "Id cannot less than zero, please try later!";
    }
}
