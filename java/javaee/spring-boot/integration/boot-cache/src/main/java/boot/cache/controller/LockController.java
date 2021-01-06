package boot.cache.controller;

import boot.cache.service.ILockService;
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
@RequestMapping("/lock")
public class LockController {

  @Resource ILockService lockService;

  @GetMapping("/brands")
  public Map getBrands() {

    return lockService.getAllBrands();
  }
}
