package com.augmentum.springboot.integration.configuration;

import com.augmentum.springboot.integration.filter.CustomFilter;
import com.augmentum.springboot.integration.listner.CustomListener;
import com.augmentum.springboot.integration.servlet.CustomServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author zack
 * @create 2019-12-25 20:44
 * @function config Servlet Filter and Listener
 */
@Configuration
public class ServerConfiguration {

  @Bean
  public ServletRegistrationBean customServlet() {
    ServletRegistrationBean registrationBean =
        new ServletRegistrationBean(new CustomServlet(), "/customServlet");
    registrationBean.setLoadOnStartup(1);
    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean customFilter() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    registrationBean.setFilter(new CustomFilter());
    registrationBean.setUrlPatterns(Arrays.asList("/person"));
    return registrationBean;
  }

  @Bean
  public ServletListenerRegistrationBean myListener() {
    ServletListenerRegistrationBean<CustomListener> registrationBean =
        new ServletListenerRegistrationBean<>(new CustomListener());
    return registrationBean;
  }

  @Bean
  public WebServerFactoryCustomizer embeddedServletContainerCustomizer() {
    return (factory) -> {
      ConfigurableWebServerFactory configurableWebServerFactory =
          (ConfigurableWebServerFactory) factory;
      configurableWebServerFactory.setPort(8080);
    };
  }
}
