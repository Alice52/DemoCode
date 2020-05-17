package cn.edu.ntu.javaee.springboot.workflow.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zack <br>
 * @create 2020-05-17 15:50 <br>
 * @project springboot <br>
 */
@Component
public class CustomCommandLineRunner implements CommandLineRunner {
  private static final Logger LOG = LoggerFactory.getLogger(CustomCommandLineRunner.class);

  @Override
  public void run(String... args) throws Exception {
    LOG.info("CustomCommandLineRunner...run");
  }
}
