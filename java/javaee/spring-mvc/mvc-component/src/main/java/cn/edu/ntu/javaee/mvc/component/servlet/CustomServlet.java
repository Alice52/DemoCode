package cn.edu.ntu.javaee.mvc.component.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * usage: need register in web.xml if no web.xml, <br>
 * it will also can be register by @Configuration + @Bean
 *
 * @author zack
 * @create 2019-11-11 21:23
 */
@Component
public class CustomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        ApplicationContext ctx = (ApplicationContext) context.getAttribute("applicationContext");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
