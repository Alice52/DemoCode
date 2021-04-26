package cn.edu.ntu.boot.exception.sample.contoller;

import cn.edu.ntu.boot.exception.sample.service.AaService;
import cn.edu.ntu.javaee.boot.common.model.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2021-04-25 13:09 <br>
 * @project integration <br>
 */
@RestController
public class AaController {

  @Resource private AaService aService;

  @GetMapping("/hello-a/{name}")
  public JsonObject helloA(@PathVariable(value = "name", required = true) String name) {
    aService.helloA(name);

    return new JsonObject();
  }

  @GetMapping("/hello-a")
  public JsonObject hello(@RequestParam(value = "name") String name) {
    aService.helloA(null);

    return new JsonObject();
  }
}
