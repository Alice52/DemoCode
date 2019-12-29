package com.augmentum.springboot.integration.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {
  private static final Logger LOG = LoggerFactory.getLogger(MybatisConfiguration.class);

  //  public ConfigurationCustomizer configurationCustomizer() {
  //    return new ConfigurationCustomizer() {
  //
  //      @Override
  //      public void customize(org.apache.ibatis.session.Configuration configuration) {
  //
  //        configuration.setMapUnderscoreToCamelCase(true);
  //      }
  //
  //    };
  //  }
}
