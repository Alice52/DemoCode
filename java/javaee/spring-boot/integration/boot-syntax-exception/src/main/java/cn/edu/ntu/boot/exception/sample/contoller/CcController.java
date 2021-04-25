package cn.edu.ntu.boot.exception.sample.contoller;

import cn.edu.ntu.boot.exception.sample.service.CcService;
import cn.edu.ntu.javaee.boot.common.model.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2021-04-25 15:22 <br>
 * @project integration <br>
 */
@RestController
public class CcController {
  @Resource private CcService ccService;

  @GetMapping("/hello-c/transaction")
  public JsonObject helloA(@RequestParam(value = "name") String name) {
    ccService.transactionWithValidate(name);

    return new JsonObject();
  }
}
