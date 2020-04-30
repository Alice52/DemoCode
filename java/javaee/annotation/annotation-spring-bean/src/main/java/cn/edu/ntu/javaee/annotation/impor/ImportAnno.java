package cn.edu.ntu.javaee.annotation.impor;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import cn.edu.ntu.javaee.annotation.impor.factory.DogFactoryBean;
import cn.edu.ntu.javaee.annotation.impor.registrar.CustomImportBeanDefinitionRegistrar;
import cn.edu.ntu.javaee.annotation.impor.selector.CustomImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <code>@Import</code> will put class to IOC container, and bean name is full class name. <br>
 * And call NoArgsConstructor of Person. <br>
 *
 * @author zack <br>
 * @create 2020-04-29 21:30 <br>
 */
@Configuration
@Import({Person.class, CustomImportSelector.class, CustomImportBeanDefinitionRegistrar.class})
public class ImportAnno {

  @Bean
  public DogFactoryBean dogFactoryBean() {

    return new DogFactoryBean();
  }
}
