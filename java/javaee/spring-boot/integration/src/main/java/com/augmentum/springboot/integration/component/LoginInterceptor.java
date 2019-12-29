package com.augmentum.springboot.integration.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
  private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);
}
