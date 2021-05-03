package cn.edu.ntu.javaee.mvc.component.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * usage: need register in web.xml.
 *
 * @author zack
 * @create 2019-11-11 21:19
 */
@Component
public class CustomServletContextListener implements ServletContextListener {
    /**
     * created when tomcat container startup
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("applicationContext", ctx);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}
