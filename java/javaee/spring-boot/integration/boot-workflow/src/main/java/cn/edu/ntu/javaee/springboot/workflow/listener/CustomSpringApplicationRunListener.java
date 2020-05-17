package cn.edu.ntu.javaee.springboot.workflow.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author zack <br>
 * @create 2020-05-17 15:47 <br>
 * @project springboot <br>
 */
public class CustomSpringApplicationRunListener implements SpringApplicationRunListener {
  private static final Logger LOG =
      LoggerFactory.getLogger(CustomSpringApplicationRunListener.class);

  public CustomSpringApplicationRunListener(SpringApplication application, String[] args) {}

  @Override
  public void starting() {
    LOG.info("CustomSpringApplicationRunListener...starting...");
  }

  @Override
  public void environmentPrepared(ConfigurableEnvironment environment) {
    LOG.info("CustomSpringApplicationRunListener...environmentPrepared...");
  }

  @Override
  public void contextPrepared(ConfigurableApplicationContext context) {
    LOG.info("CustomSpringApplicationRunListener...contextPrepared...");
  }

  @Override
  public void contextLoaded(ConfigurableApplicationContext context) {
    LOG.info("CustomSpringApplicationRunListener...contextLoaded...");
  }

  @Override
  public void started(ConfigurableApplicationContext context) {
    LOG.info("CustomSpringApplicationRunListener...started...");
  }

  @Override
  public void running(ConfigurableApplicationContext context) {
    LOG.info("CustomSpringApplicationRunListener...running...");
  }

  @Override
  public void failed(ConfigurableApplicationContext context, Throwable exception) {
    LOG.info("CustomSpringApplicationRunListener...failed...");
  }
}
