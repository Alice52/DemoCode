package cn.edu.ntu.javaee.springmvc.servlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** @author zack */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    /** /WEB-INF/views/success.jsp */
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
