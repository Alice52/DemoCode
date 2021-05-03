package cn.edu.ntu.boot.starter.controller;

import cn.edu.ntu.javaee.springboot.starter.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-05-17 17:07 <br>
 * @project springboot <br>
 */
@RestController
public class HelloController {

    @Resource HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.sayHellAtguigu("man");
    }
}
