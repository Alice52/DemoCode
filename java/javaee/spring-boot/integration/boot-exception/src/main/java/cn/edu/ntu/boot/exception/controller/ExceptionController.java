package cn.edu.ntu.boot.exception.controller;

import cn.edu.ntu.boot.exception.exception.UserNotExistException;
import cn.edu.ntu.javaee.boot.common.model.ErrorMessage;
import cn.edu.ntu.javaee.boot.common.model.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zack <br>
 * @create 2020-04-27 20:30 <br>
 */
@RestController
public class ExceptionController {

  @GetMapping(value = "/userNotExistException")
  public JsonObject userNotExistException() {
    throw new UserNotExistException();
  }

  @GetMapping(value = "/runtimeException")
  public ErrorMessage exception() {
    throw new RuntimeException();
  }
}
