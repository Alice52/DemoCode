package com.augmentum.springboot.integration.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CustomListener implements ServletContextListener {
  private static final Logger LOG = LoggerFactory.getLogger(CustomListener.class);

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    LOG.info("contextInitialized...");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    LOG.info("contextDestroyed...");
  }
}
