package cn.edu.ntu.javaee.springboot.validation.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-07-29 18:59 <br>
 * @project validation <br>
 */
@Order(Ordered.LOWEST_PRECEDENCE)
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        BeanDefinition testServiceImpl = beanFactory.getBeanDefinition("testServiceImpl");
        MutablePropertyValues propertyValues = testServiceImpl.getPropertyValues();
        // TODO: exception thrown
        // propertyValues.addPropertyValue("exposeProxy", true);
    }
}
