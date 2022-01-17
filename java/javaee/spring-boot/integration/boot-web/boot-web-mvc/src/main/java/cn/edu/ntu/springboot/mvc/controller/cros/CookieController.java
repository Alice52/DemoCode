package cn.edu.ntu.springboot.mvc.controller.cros;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

/**
 * @author asd <br>
 * @create 2022-01-12 3:49 PM <br>
 * @project boot-mybatis-rwa <br>
 */
@Slf4j
@RestController
@RequestMapping("/cookie")
public class CookieController {

    @SneakyThrows
    @GetMapping("/test")
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");
        log.info("收到请求: {}, 方法: {}, Origin头: {}", requestURI, method, originHeader);

        setCookieIfNecessary(req, resp, 600);

        resp.getWriter().write("hello cookie...");
    }

    @GetMapping("/cors")
    public void cors(HttpServletRequest req, HttpServletResponse resp) {
        allowCors(req, resp);

        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");

        log.info("收到请求: {}, 方法: {}, Origin头: {}", requestURI, method, originHeader);

        setCookieIfNecessary(req, resp, 600);
    }

    @GetMapping("/cors2")
    public void cors2(HttpServletRequest req, HttpServletResponse resp) {
        allowCors(req, resp);

        String requestURI = req.getRequestURI();
        String method = req.getMethod();
        String originHeader = req.getHeader("Origin");

        log.info("收到请求: {}, 方法: {}, Origin头: {}", requestURI, method, originHeader);

        setCookieIfNecessary(req, resp, 0);
    }

    private void allowCors(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
    }

    private void setCookieIfNecessary(
            HttpServletRequest req, HttpServletResponse resp, int expireTime) {

        List<Cookie> myCookies = new ArrayList<>();
        if (req.getCookies() != null) {
            myCookies =
                    Arrays.stream(req.getCookies())
                            .filter(c -> c.getName().equals("name") || c.getName().equals("age"))
                            .collect(toList());
        }

        //        if (myCookies.isEmpty()) {
        ResponseCookie cookie =
                ResponseCookie.from("name", "YourBatman" + new Random().nextInt())
                        .maxAge(expireTime)
                        .domain("mc-eureka")
                        .sameSite("none")
                        .secure(true)
                        .path("/")
                        .build();
        //            cookie.setSecure(true);
        resp.setHeader(HttpHeaders.SET_COOKIE, String.valueOf(cookie));
        ResponseCookie cookie2 =
                ResponseCookie.from("name2", "Your2Batman" + new Random().nextInt())
                        .maxAge(expireTime)
                        .domain("mc-eureka")
                        .sameSite("none")
                        .secure(true)
                        .path("/")
                        .build();
        //            cookie.setSecure(true);
        resp.setHeader(HttpHeaders.SET_COOKIE2, String.valueOf(cookie2));
        Cookie cookie1 = new Cookie("age", "18");
        resp.addCookie(cookie1);
        //        }
    }
}
