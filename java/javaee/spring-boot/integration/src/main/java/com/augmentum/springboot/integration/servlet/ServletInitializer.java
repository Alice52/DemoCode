package com.augmentum.springboot.integration.servlet;

import com.augmentum.springboot.integration.SpringBootIntegrationApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
  private static final Logger LOG = LoggerFactory.getLogger(ServletInitializer.class);

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SpringBootIntegrationApplication.class);
  }
}
