package cn.edu.ntu.springboot.mvc.controller.cros;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author asd <br>
 * @create 2022-01-17 2:35 PM <br>
 * @project boot-mybatis-rwa <br>
 */
@Slf4j
@RestController
@RequestMapping("/multiple-origins-cors")
public class MultipleOriginsCorsController {

    @GetMapping
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");
        log.info("收到请求：{}，方法：{}， Origin头：{}", requestURI, method, originHeader);

        resp.getWriter().write("hello multiple origins cors...");
        setCrosHeader(resp);
    }

    /** 写跨域响应头 */
    private void setCrosHeader(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
    }
}
