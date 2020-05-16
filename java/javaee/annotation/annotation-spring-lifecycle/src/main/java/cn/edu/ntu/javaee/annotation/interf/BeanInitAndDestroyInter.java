package cn.edu.ntu.javaee.annotation.interf;

import cn.edu.ntu.javaee.annotation.factory.CustomBeanDefinitionRegistryPostProcessor;
import cn.edu.ntu.javaee.annotation.factory.CustomBeanFactoryPostProcessor;
import cn.edu.ntu.javaee.annotation.interf.model.Dog;
import cn.edu.ntu.javaee.annotation.listener.CustomApplicationListener;
import cn.edu.ntu.javaee.annotation.processor.CustomBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author zack <br>
 * @create 2020-04-30 12:13 <br>
 */
@Configuration
@ComponentScan(
    basePackages = "cn.edu.ntu.javaee.annotation",
    includeFilters = {
      @ComponentScan.Filter(
          type = FilterType.ASSIGNABLE_TYPE,
          classes = {CustomBeanPostProcessor.class}),
      @ComponentScan.Filter(
          type = FilterType.ASSIGNABLE_TYPE,
          classes = {
            CustomBeanFactoryPostProcessor.class,
            CustomBeanDefinitionRegistryPostProcessor.class
          }),
      @ComponentScan.Filter(
          type = FilterType.ASSIGNABLE_TYPE,
          classes = {CustomApplicationListener.class}),
    })
public class BeanInitAndDestroyInter {

  @Bean(value = "dog", initMethod = "init", destroyMethod = "destroy0")
  public Dog injectPerson() {

    return new Dog();
  }
}
