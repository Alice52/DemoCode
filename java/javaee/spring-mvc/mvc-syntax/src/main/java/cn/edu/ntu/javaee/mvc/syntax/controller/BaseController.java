package cn.edu.ntu.javaee.mvc.syntax.controller;

import cn.edu.ntu.javaee.mvc.common.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zack
 * @create 2019-11-09 19:50
 * @function
 */
@Controller
@RequestMapping("/base")
public class BaseController {

  @RequestMapping(
      value = "/hello",
      method = {RequestMethod.DELETE, RequestMethod.GET})
  public String hello() {
    return "index";
  }

  /** http://--/base/hello/1?name=zack&age=18 */
  @GetMapping("/hello/{id}")
  public String hello(
      // need servlet-api dependency
      HttpServletRequest request,
      HttpServletResponse response,
      @ModelAttribute("user") User user,
      @PathVariable("id") String id,
      @RequestParam("name") String name,
      @RequestParam(value = "age", required = false, defaultValue = "0") int age,
      @RequestHeader(value = "Accept-Language", required = false, defaultValue = "0")
          String acceptLanguage,
      @CookieValue(value = "JSESSIONID", required = false, defaultValue = "0") String sessionId) {

    return "index";
  }

  @RequestMapping(value = "/servlet/{id}")
  public String getContainerFServletContext(HttpSession session, @PathVariable("id") String id)
      throws ServletException, IOException {

    ServletContext servletContext = session.getServletContext();
    ApplicationContext ctx =
        (ApplicationContext)
            servletContext.getAttribute(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    WebApplicationContext webApplicationContext =
        WebApplicationContextUtils.getWebApplicationContext(servletContext);

    return "index";
  }
}
