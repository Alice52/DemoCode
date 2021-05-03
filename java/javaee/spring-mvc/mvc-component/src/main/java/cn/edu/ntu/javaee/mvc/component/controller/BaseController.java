package cn.edu.ntu.javaee.mvc.component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zack
 * @create 2019-11-09 19:50
 * @function
 */
@Controller
public class BaseController {

    @RequestMapping(value = "/helloServlet")
    public String hello() {
        return "success";
    }
}
