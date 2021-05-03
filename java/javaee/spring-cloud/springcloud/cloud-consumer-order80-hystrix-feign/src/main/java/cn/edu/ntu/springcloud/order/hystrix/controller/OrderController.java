package cn.edu.ntu.springcloud.order.hystrix.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.order.hystrix.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-04-02 23:36 <br>
 */
@Slf4j
@RestController
@RequestMapping(value = "/consumer")
@DefaultProperties(defaultFallback = "getPaymentInfoTimeoutHandler")
public class OrderController {

    @Resource private HystrixService hystrixService;

    @GetMapping("/hystrix/success-info")
    @HystrixCommand()
    public JsonResult getPaymentInfo() {
        return hystrixService.getPaymentInfos();
    }

    @GetMapping("/hystrix/fail-info")
    @HystrixCommand(
            fallbackMethod = "getPaymentInfoTimeoutHandler",
            commandProperties = {
                @HystrixProperty(
                        name = "execution.isolation.thread.timeoutInMilliseconds",
                        value = "4000")
            })
    public JsonResult getPaymentInfoTimeout() {
        log.warn("message");
        return hystrixService.getPaymentInfoTimeout();
    }

    @GetMapping("/hystrix/error-info")
    @HystrixCommand()
    public JsonResult getPaymentInfoError() {
        return hystrixService.getPaymentInfoError();
    }

    public JsonResult getPaymentInfoTimeoutHandler() {

        String message =
                "Consumer Thread Pool: "
                        + Thread.currentThread().getName()
                        + ",call getPaymentInfoTimeoutHandler("
                        + "): success";
        log.warn(message);

        return new JsonResult(400, message, null);
    }
}
