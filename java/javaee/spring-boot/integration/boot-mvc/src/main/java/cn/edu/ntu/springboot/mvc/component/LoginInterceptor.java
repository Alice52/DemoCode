package cn.edu.ntu.springboot.mvc.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/** @author zack */
public class LoginInterceptor implements HandlerInterceptor {
  private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);
}
