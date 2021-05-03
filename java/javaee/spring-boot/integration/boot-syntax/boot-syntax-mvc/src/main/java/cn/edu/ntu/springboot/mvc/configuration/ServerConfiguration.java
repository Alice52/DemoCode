package cn.edu.ntu.springboot.mvc.configuration;

import cn.edu.ntu.springboot.mvc.filter.CustomFilter;
import cn.edu.ntu.springboot.mvc.listner.CustomListener;
import cn.edu.ntu.springboot.mvc.servlet.CustomServlet;
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

    @Bean(value = "servletRegistrationBean")
    public ServletRegistrationBean customServlet(CustomServlet customServlet) {
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(customServlet, "/customServlet");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean(value = "filterRegistrationBean")
    public FilterRegistrationBean customFilter(CustomFilter customFilter) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(customFilter);
        registrationBean.setUrlPatterns(Arrays.asList("/person"));
        return registrationBean;
    }

    @Bean(value = "servletListenerRegistrationBean")
    public ServletListenerRegistrationBean myListener(CustomListener customListener) {
        ServletListenerRegistrationBean<CustomListener> registrationBean =
                new ServletListenerRegistrationBean<>(customListener);
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
