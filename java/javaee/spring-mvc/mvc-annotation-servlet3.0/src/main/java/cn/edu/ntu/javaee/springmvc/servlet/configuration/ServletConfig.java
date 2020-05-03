package cn.edu.ntu.javaee.springmvc.servlet.configuration;

import cn.edu.ntu.javaee.springmvc.servlet.interceptor.CustomInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @EnableWebMvc function same as <mvc:annotation-driven/>
 *
 * @author zack <br>
 * @create 2020-05-03 18:35 <br>
 */
@ComponentScan(
    value = "cn.edu.ntu.javaee.springmvc.servlet",
    includeFilters = {
      @ComponentScan.Filter(
          type = FilterType.ANNOTATION,
          classes = {Controller.class})
    },
    useDefaultFilters = false)
@EnableWebMvc
public class ServletConfig implements WebMvcConfigurer {

  /**
   * same as <mvc:default-servlet-handler/>
   *
   * @param configurer
   */
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }


  /**
   * same as: <br>
   * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
   *     <property name="prefix" value="/WEB-INF/views/"/>
   *     <property name="suffix" value=".jsp"/>
   * </bean>
   *
   * @param registry
   */
  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp("/WEB-INF/views/", ".jsp");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/**");
  }
}
