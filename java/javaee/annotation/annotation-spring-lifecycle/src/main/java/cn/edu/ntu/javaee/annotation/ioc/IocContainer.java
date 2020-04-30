package cn.edu.ntu.javaee.annotation.ioc;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-04-30 13:33 <br>
 */
@Configuration
public class IocContainer implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  public ApplicationContext getApplicationContext() {
    return this.applicationContext;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Bean
  public Person person() {
    return new Person();
  }
}
