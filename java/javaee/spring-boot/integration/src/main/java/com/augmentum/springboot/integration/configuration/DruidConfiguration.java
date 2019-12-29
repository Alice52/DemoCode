package com.augmentum.springboot.integration.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfiguration {
  private static final Logger LOG = LoggerFactory.getLogger(DruidConfiguration.class);

  //    @ConfigurationProperties("spring.datasource")
  //    @Bean
  //    public DataSource druid() {
  //        return new DruidDataSource();
  //    }

  //    @Bean
  //    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
  //        ServletRegistrationBean<StatViewServlet> bean = new
  // ServletRegistrationBean<StatViewServlet>(new StatViewServlet(), "/druid/*");
  //        Map<String, String> initParams = new HashMap<>();
  //        initParams.put("loginUsername", "zack");
  //        initParams.put("loginPassword", "1252068782");
  //        initParams.put("allow", "");// 默认就是允许所有访问
  //        initParams.put("deny", "192.168.1.102");
  //        bean.setInitParameters(initParams);
  //
  //        return bean;
  //    }

  //    @Bean
  //    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
  //        FilterRegistrationBean<WebStatFilter> bean = new
  // FilterRegistrationBean<WebStatFilter>();
  //        bean.setFilter(new WebStatFilter());
  //        Map<String, String> initParams = new HashMap<>();
  //        initParams.put("exclusions", "*.js,*.css,/druid/*");
  //        bean.setInitParameters(initParams);
  //        bean.setUrlPatterns(Arrays.asList("/*"));
  //
  //        return bean;
  //    }
}
