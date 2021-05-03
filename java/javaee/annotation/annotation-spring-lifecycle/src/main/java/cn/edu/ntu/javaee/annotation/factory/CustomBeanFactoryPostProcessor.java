package cn.edu.ntu.javaee.annotation.factory;

import cn.edu.ntu.javaee.annotation.interf.model.Dog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-05-08 19:34 <br>
 * @project annotation <br>
 */
@Slf4j
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {

        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        Arrays.stream(definitionNames).forEach(System.out::println);

        String[] namesForType = beanFactory.getBeanNamesForType(Dog.class);
        Arrays.stream(namesForType).forEach(System.out::println);

        log.info("CustomBeanFactoryPostProcessor...postProcessBeanFactory");
    }
}
