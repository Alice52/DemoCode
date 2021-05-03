package cn.edu.ntu.springcloud.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired private StorageService storageService;

    /** 扣减库存 */
    @RequestMapping("/storage/decrease")
    public JsonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new JsonResult(200, "扣减库存成功！");
    }
}
