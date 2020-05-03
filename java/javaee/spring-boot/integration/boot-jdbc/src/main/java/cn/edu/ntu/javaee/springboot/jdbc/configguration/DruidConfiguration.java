package cn.edu.ntu.javaee.springboot.jdbc.configguration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.ResourceServlet;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** @author zack */
@Configuration
public class DruidConfiguration {
  private static final Logger LOG = LoggerFactory.getLogger(DruidConfiguration.class);

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DruidDataSource configDruid() {
    return new DruidDataSource();
  }

  /** datasource management */
  @Bean
  public ServletRegistrationBean<StatViewServlet> configStatViewServlet() {
    ServletRegistrationBean<StatViewServlet> statServletBean =
        new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
    Map<String, String> initParams = new HashMap<>();
    initParams.put(ResourceServlet.PARAM_NAME_USERNAME, "admin");
    initParams.put(ResourceServlet.PARAM_NAME_PASSWORD, "admin");
    initParams.put(ResourceServlet.PARAM_NAME_ALLOW, "");
    initParams.put(ResourceServlet.PARAM_NAME_DENY, "192.168.43.143");
    statServletBean.setInitParameters(initParams);

    return statServletBean;
  }

  @Bean
  public FilterRegistrationBean<WebStatFilter> configWebStatFilter() {
    FilterRegistrationBean<WebStatFilter> webFilterBean = new FilterRegistrationBean<>();
    webFilterBean.setFilter(new WebStatFilter());
    Map<String, String> initParams = new HashMap<>();
    initParams.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");

    webFilterBean.setInitParameters(initParams);
    webFilterBean.setUrlPatterns(Arrays.asList("/*"));

    return webFilterBean;
  }
}
