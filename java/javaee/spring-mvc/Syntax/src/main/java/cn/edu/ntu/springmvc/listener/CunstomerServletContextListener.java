package cn.edu.ntu.springmvc.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author zack
 * @create 2019-11-11 21:19
 * @function
 */
public class CunstomerServletContextListener implements ServletContextListener {

  @Override
  // created when tomcat container startup
  public void contextInitialized(ServletContextEvent sce) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    ServletContext servletContext = sce.getServletContext();
    servletContext.setAttribute("applicationContext", ctx);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {}
}
