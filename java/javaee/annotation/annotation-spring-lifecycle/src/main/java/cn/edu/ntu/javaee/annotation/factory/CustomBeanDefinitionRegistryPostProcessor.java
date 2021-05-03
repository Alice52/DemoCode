package cn.edu.ntu.javaee.annotation.factory;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author zack <br>
 * @create 2020-05-08 19:53 <br>
 * @project annotation <br>
 */
@Slf4j
public class CustomBeanDefinitionRegistryPostProcessor
        implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
            throws BeansException {
        log.info(
                "1. CustomBeanDefinitionRegistryPostProcessor...postProcessBeanDefinitionRegistry");

        registry.registerBeanDefinition("PERSON", new RootBeanDefinition(Person.class));
        registry.registerBeanDefinition(
                "PERSON2",
                BeanDefinitionBuilder.rootBeanDefinition(Person.class).getBeanDefinition());
        registry.removeBeanDefinition("PERSON2");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        log.info("2. CustomBeanDefinitionRegistryPostProcessor...postProcessBeanFactory");
    }
}
