package cn.edu.ntu.javaee.springmvc.servlet.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** @author zack */
@Slf4j
public class CustomListener implements ServletContextListener {

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
    log.info("UserListener...contextDestroyed...");
  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    ServletContext servletContext = arg0.getServletContext();
    log.info("UserListener...contextInitialized...");
  }
}
