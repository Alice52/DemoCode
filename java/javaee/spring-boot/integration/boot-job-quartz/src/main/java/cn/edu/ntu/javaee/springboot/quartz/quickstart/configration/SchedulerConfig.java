package cn.edu.ntu.javaee.springboot.quartz.quickstart.configration;

import cn.edu.ntu.javaee.springboot.quartz.quickstart.job.SimpleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Un-Recommend.
 *
 * <p>Beans of the following types are automatically picked up and associated with the Scheduler.
 *
 * @see cn.edu.ntu.javaee.springboot.quartz.quickstart.component.JobInit
 * @author zack
 * @create 2019-09-22 0:58
 * @function
 */
// @Configuration
public class SchedulerConfig {

  private static final String DEFAULT_CRON = "* * * * * ? *";
  private String CORN_ADD_USER = DEFAULT_CRON;

  @Bean
  public JobDetail sampleJobDetail() {
    return JobBuilder.newJob(SimpleJob.class)
        .withIdentity("sampleJob")
        .usingJobData("name", "World")
        .storeDurably()
        .build();
  }

  @Bean
  public Trigger sampleJobTrigger() {

    return TriggerBuilder.newTrigger()
        .forJob(sampleJobDetail())
        .withIdentity("sampleTrigger")
        .withSchedule(
            SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
        .build();
  }

  @Bean
  public JobDetail batchAddUsersJobDetail() {

    return JobBuilder.newJob(SimpleJob.class)
        .withIdentity("batchAddUsersJob")
        .storeDurably()
        .build();
  }

  @Bean
  public Trigger batchAddUsersTrigger() {

    return TriggerBuilder.newTrigger()
        .forJob("batchAddUsersJob")
        .withIdentity("batchAddUsersJobTrigger")
        .withSchedule(CronScheduleBuilder.cronSchedule(CORN_ADD_USER))
        .build();
  }
}
