package cn.edu.ntu.javaee.annotation.controller;

import cn.edu.ntu.javaee.annotation.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-04-30 17:55 <br>
 */
@RestController
public class JsrController {

  @Resource public HelloService helloService;
}
