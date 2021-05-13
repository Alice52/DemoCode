package cn.edu.ntu.javaee.springmvc.servlet.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * usage: http://localhost:8080/servlet3_0_war/hello
 *
 * @author zack <br>
 * @create 2020-05-03 17:40 <br>
 */
@WebFilter(value = "/*", asyncSupported = true)
@Slf4j
public class HelloFilter extends HttpFilter {

    public HelloFilter() {
        super();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        log.info("HelloFilter...doFilter1");
        super.doFilter(req, res, chain);
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        log.info("HelloFilter...doFilter2");
        super.doFilter(req, res, chain);
    }
}
