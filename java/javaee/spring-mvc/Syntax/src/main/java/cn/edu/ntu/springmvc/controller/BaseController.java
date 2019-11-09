package cn.edu.ntu.springmvc.controller;

import cn.edu.ntu.springmvc.common.response.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zack
 * @create 2019-11-09 19:50
 * @function
 */

@Controller
@RequestMapping("/base")
public class BaseController {

    @RequestMapping("/hello")
    public JsonResult hello(){

        JsonResult result = new JsonResult();

        result.setJsonData(null);
        result.setMessage("ok");
        result.setSuccess(1);

        return result;
    }
}
