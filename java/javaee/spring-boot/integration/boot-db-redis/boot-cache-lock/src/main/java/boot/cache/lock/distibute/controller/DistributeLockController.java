package boot.cache.lock.distibute.controller;

import boot.cache.lock.distibute.service.IDistributeLockService;
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
@RequestMapping("/distribute-lock")
public class DistributeLockController {

  @Resource IDistributeLockService lockService;

  @GetMapping("/park")
  public void park() {

    lockService.go();
  }

  @GetMapping("/brands")
  public Map getBrands() {

    return lockService.getAllBrands();
  }

  @GetMapping("/write")
  public String write() {

    return lockService.writeValue();
  }

  @GetMapping("/read")
  public String read() {

    return lockService.readValue();
  }

  @GetMapping("/class-door-close")
  public void classDoorClose() {

    lockService.lockDoor();
  }

  @GetMapping("/school-door-close")
  public void schoolDoorClose() {

    lockService.lockSchoolDoor();
  }
}
