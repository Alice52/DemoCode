package cn.edu.ntu.javaee.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Optional;

/**
 * @author zack
 * @create 2019-10-27 21:04
 * @function CustomBeanPostProcessor
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {
  private static final Logger LOG = LoggerFactory.getLogger(BeanLifecycle.class);

  /**
   * @param bean
   * @param beanName
   * @return bean
   * @throws BeansException
   * @function do property validate
   */
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {

    Optional.ofNullable(beanName)
        .filter(name -> name.equals("person4LifeCycle"))
        .ifPresent(
            name ->
                LOG.info("bean lifecycle: step3: pass bean to postProcessBeforeInitialization"));

    return bean;
  }

    /**
     *
     * @param bean
     * @param beanName
     * @return bean
     * @throws BeansException
     * @function validate init method whether work
     */
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

    Optional.ofNullable(beanName)
        .filter(name -> name.equals("person4LifeCycle"))
        .ifPresent(
            name -> LOG.info("bean lifecycle: step5: pass bean to postProcessAfterInitialization"));
    return bean;
  }
}
