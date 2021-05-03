package cn.edu.ntu.javaee.mvc.syntax.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2020-05-03 14:11 <br>
 */
@Controller
public class DsController {

    private static final Logger LOG = LoggerFactory.getLogger(DsController.class);

    @RequestMapping("/testRedirectView")
    public String testRedirectView() {

        return "redirect:/ok";
    }

    @RequestMapping("/ok")
    public String ok() {

        return "ok";
    }

    @RequestMapping("/testView")
    public String testView() {

        return "success";
    }

    /**
     * usage: ${requestScope.loginMsg }
     *
     * @param model
     * @return success.jsp
     */
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("loginMsg", "wrong password");
        return "success";
    }

    /**
     * usage: ${requestScope.password}
     *
     * @param map
     * @return success.jsp
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        // BindingAwareModelMap
        LOG.info(map.getClass().getName());
        map.put("password", "123456");

        return "success";
    }

    /**
     * this map cannot be retrieved.
     *
     * @return
     */
    @RequestMapping("/testMap2")
    public String testMap2() {
        Map<String, Object> map = new HashMap<>(4);
        // BindingAwareModelMap
        LOG.info(map.getClass().getName());
        map.put("password", "123456");

        return "success";
    }

    /**
     * usage: ${requestScope.username}
     *
     * @return success.jsp
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("username", "Admin");
        mav.setViewName("success");

        return mav;
    }
}
