package cn.edu.ntu.boot.swagger2.controller;

import cn.edu.ntu.javaee.boot.common.model.Person;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zack <br>
 * @create 2020-04-27 12:35 <br>
 */
@Api
@RestController
public class TestController {

    @PostMapping(value = "/test")
    public Person hello(Person person) {
        return person;
    }
}
