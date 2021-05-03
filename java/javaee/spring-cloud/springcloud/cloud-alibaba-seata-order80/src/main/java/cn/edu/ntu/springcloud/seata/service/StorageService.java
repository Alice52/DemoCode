package cn.edu.ntu.springcloud.seata.service;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zzyy
 * @create 2020-02-26 15:22
 */
@FeignClient(value = "cloud-seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    JsonResult decrease(
            @RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
