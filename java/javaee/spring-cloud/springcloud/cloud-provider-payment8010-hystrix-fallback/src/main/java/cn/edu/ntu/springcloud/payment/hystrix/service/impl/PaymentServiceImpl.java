package cn.edu.ntu.springcloud.payment.hystrix.service.impl;

import cn.edu.ntu.springcloud.payment.hystrix.service.PaymentService;
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
    @HystrixCommand(
            fallbackMethod = "getPaymentInfoTimeoutHandler",
            commandProperties = {
                @HystrixProperty(
                        name = "execution.isolation.thread.timeoutInMilliseconds",
                        value = "3000")
            })
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
            fallbackMethod = "getPaymentInfoTimeoutHandler",
            commandProperties = {
                @HystrixProperty(
                        name = "execution.isolation.thread.timeoutInMilliseconds",
                        value = "3000")
            })
    public String getPaymentInfoError(String id) throws InterruptedException {

        int a = 1 / 0;
        String message =
                "Thread Pool: "
                        + Thread.currentThread().getName()
                        + ",call getPaymentInfoTimeout("
                        + id
                        + "): success";
        log.warn(message);

        return message;
    }

    public String getPaymentInfoTimeoutHandler(String id) {
        String message =
                "Provider Thread Pool: "
                        + Thread.currentThread().getName()
                        + ",call getPaymentInfoTimeoutHandler("
                        + "): success";
        LOG.warn(message);

        return message;
    }
}
