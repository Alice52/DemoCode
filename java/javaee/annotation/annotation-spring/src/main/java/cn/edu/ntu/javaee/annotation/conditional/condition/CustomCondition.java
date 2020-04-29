package cn.edu.ntu.javaee.annotation.conditional.condition;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zack <br>
 * @create 2020-04-29 20:53 <br>
 */
@Slf4j
public class CustomCondition implements Condition {

  /**
   * If the env is window, it will be inject to IOC container. <br>
   *
   * @param context the condition context
   * @param metadata metadata of the {@link org.springframework.core.type.AnnotationMetadata class},
   *     which is annotation info
   */
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

    ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
    ClassLoader classLoader = context.getClassLoader();
    log.info(String.valueOf(classLoader));
    Environment environment = context.getEnvironment();
    BeanDefinitionRegistry registry = context.getRegistry();
    ResourceLoader resourceLoader = context.getResourceLoader();
    String osName = environment.getProperty("os.name");

    return StrUtil.containsIgnoreCase(osName, "windows");
  }
}
