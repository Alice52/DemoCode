package cn.edu.ntu.javaee.springmvc.servlet.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * usage: http://localhost:8080/servlet3_0_war/hello
 *
 * @author zack <br>
 * @create 2020-05-03 17:40 <br>
 */
@WebListener
@Slf4j
public class HelloListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        log.info("HelloListener...contextDestroyed...");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext servletContext = arg0.getServletContext();
        log.info("HelloListener...contextInitialized...");
    }
}
