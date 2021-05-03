package boot.cache.lock.local.controller;

import boot.cache.lock.local.service.ILocalLockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-01-05 21:05 <br>
 * @project springboot <br>
 */
@RestController
@RequestMapping("/local-lock")
public class LocalLockController {

    @Resource ILocalLockService lockService;

    @GetMapping("/brands")
    public Map getBrands() {

        return lockService.getAllBrands();
    }
}
