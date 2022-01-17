package cn.edu.ntu.springboot.mvc.configuration;

import cn.edu.ntu.springboot.mvc.component.CustomLocaleResolver;
import cn.edu.ntu.springboot.mvc.component.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zack
 * @create 2019-12-22 20:02
 * @function config mvc resource handler
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {}

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {}

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/cors.html", "/user/login", "/static/**", "/webjars/**");
    }

    @Bean
    public LocaleResolver localeResolver() {

        return new CustomLocaleResolver();
    }
}
