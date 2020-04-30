package cn.edu.ntu.javaee.annotation.controller;

import cn.edu.ntu.javaee.annotation.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

/**
 * <code> @Autowired</code> will get by type firstly; <br>
 * If find more than one bean satisfy requirement, then will ues bean name as filter. <br>
 * Also can use <code>@Qualifier("helloService2")</code> to specify bean. <br>
 * And can use <code>@Primary</code> to specify bean. <br>
 *
 * @author zack <br>
 * @create 2020-04-30 17:00 <br>
 */
@RestController
public class HelloController {

  @Qualifier(value = "helloService2")
  @Autowired(required = false)
  public HelloService helloService;
}
