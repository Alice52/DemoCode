package cn.edu.ntu.springboot.mvc.controller.cros;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author asd <br>
 * @create 2022-01-12 3:49 PM <br>
 * @project boot-mybatis-rwa <br>
 */
@Slf4j
@RestController
@RequestMapping("/cors")
public class CorsController {

    @GetMapping("/test")
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        resp.setHeader("Access-Control-Expose-Headers", "token,secret");
        resp.setHeader("Access-Control-Allow-Headers", "token,secret");

        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");

        log.info("收到请求: {}, 方法: {}, Origin头: {}", requestURI, method, originHeader);
    }
}
