package cn.edu.ntu.javaee.springboot.workflow.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-05-17 15:50 <br>
 * @project springboot <br>
 */
@Component
public class CustomApplicationRunner implements ApplicationRunner {
  private static final Logger LOG = LoggerFactory.getLogger(CustomApplicationRunner.class);

  @Override
  public void run(ApplicationArguments args) throws Exception {
    LOG.info("CustomApplicationRunner...run...");
  }
}
