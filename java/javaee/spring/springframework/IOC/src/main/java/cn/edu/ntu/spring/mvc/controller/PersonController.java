package cn.edu.ntu.spring.mvc.controller;

import cn.edu.ntu.spring.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author zack
 * @create 2019-10-27 22:35
 * @function
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    public void register() {
        personService.handleRegister();
    }
}
