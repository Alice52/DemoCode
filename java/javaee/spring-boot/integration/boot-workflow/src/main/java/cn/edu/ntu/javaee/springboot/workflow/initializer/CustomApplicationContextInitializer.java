package cn.edu.ntu.javaee.springboot.workflow.initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zack <br>
 * @create 2020-05-17 15:45 <br>
 * @project springboot <br>
 */
public class CustomApplicationContextInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  private static final Logger LOG =
      LoggerFactory.getLogger(CustomApplicationContextInitializer.class);

  @Override
  public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
    LOG.info("CustomApplicationContextInitializer...initialize...");
  }
}
