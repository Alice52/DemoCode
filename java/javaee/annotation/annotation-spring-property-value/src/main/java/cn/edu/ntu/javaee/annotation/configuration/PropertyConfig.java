package cn.edu.ntu.javaee.annotation.configuration;

import cn.edu.ntu.javaee.annotation.model.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <code>@PropertySource</code> will get property value and put it into env vars. <br>
 *
 * @author zack <br>
 * @create 2020-04-30 15:50 <br>
 */
@Configuration
@PropertySource(value = "classpath:cat.properties")
public class PropertyConfig {

  @Bean
  public Cat cat() {
    return new Cat();
  }
}
