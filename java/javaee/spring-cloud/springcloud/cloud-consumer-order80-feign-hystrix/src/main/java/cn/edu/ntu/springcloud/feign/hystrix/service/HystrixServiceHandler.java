package cn.edu.ntu.springcloud.feign.hystrix.service;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import org.springframework.stereotype.Component;

/**
 * TODO: the timeout issue should be config in yml??
 *
 * @author zack <br>
 * @create 2020-04-06 18:58 <br>
 */
@Component
public class HystrixServiceHandler implements HystrixService {

    @Override
    public JsonResult getPaymentInfos() {
        return new JsonResult(400, "getPaymentInfos", null);
    }

    @Override
    public JsonResult getPaymentInfoTimeout() {
        return new JsonResult(400, "getPaymentInfoTimeout", null);
    }

    @Override
    public JsonResult getPaymentInfoError() {
        return new JsonResult(400, "getPaymentInfoError", null);
    }
}
