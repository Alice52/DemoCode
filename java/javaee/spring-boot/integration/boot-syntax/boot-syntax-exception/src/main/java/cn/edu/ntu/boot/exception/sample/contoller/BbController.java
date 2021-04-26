package cn.edu.ntu.boot.exception.sample.contoller;

import cn.edu.ntu.boot.exception.sample.service.AaService;
import cn.edu.ntu.javaee.boot.common.model.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2021-04-25 15:22 <br>
 * @project integration <br>
 */
@RestController
public class BbController {
  @Resource private AaService aaService;

  @GetMapping("/hello-b/{name}")
  public JsonObject helloA(@PathVariable(value = "name", required = true) String name) {
    aaService.helloA(name);

    return new JsonObject();
  }
}
