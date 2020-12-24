package cn.edu.ntu.javaee.springboot.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author zack
 * @project boot-job-quartz
 */
@SpringBootApplication
public class QuartzApplication {

  private static final Logger LOG = LoggerFactory.getLogger(QuartzApplication.class);

  @Resource Scheduler scheduler;

  @Value("${spring.quartz.properties.org.quartz.scheduler.instanceId}")
  private String instanceId;

  @PostConstruct
  public void initInfo() throws SchedulerException {
    LOG.warn("startup server's instanceId is: {}", instanceId);
    LOG.warn(
        "instanceId got from scheduler is: {}", scheduler.getMetaData().getSchedulerInstanceId());
    LOG.warn("name got from scheduler is: {}", scheduler.getMetaData().getSchedulerName());
  }

  public static void main(String[] args) {
    SpringApplication.run(QuartzApplication.class, args);
  }
}
