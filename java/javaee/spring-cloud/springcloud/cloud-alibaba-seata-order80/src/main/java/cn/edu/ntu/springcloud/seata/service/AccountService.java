package cn.edu.ntu.springcloud.seata.service;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zack
 * @create 2020-02-26 15:22
 */
@FeignClient(value = "cloud-seata-account-service")
public interface AccountService
{
    @PostMapping(value = "/account/decrease")
    JsonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
