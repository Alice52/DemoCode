package cn.edu.ntu.javaee.annotation.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor
 *
 * populateBean(beanName, mbd, instanceWrapper); // set value of bean
 * initializeBean
 * {
 *    applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *    invokeInitMethods(beanName, wrappedBean, mbd); // execute custom init
 *    applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 *
 * @author zack <br>
 * @create 2020-04-30 12:55 <br>
 */
@Slf4j
public class CustomBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    log.info("1. postProcessBeforeInitialization, bean: {}, beanName: {}", bean, beanName);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    log.info("5. postProcessAfterInitialization, bean: {}, beanName: {}", bean, beanName);
    return bean;
  }
}
