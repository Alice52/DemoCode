package com.augmentum.job.quartz.configration;

import com.augmentum.job.quartz.scheduler.SimpleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack
 * @create 2019-09-22 0:58
 * @function
 */
@Configuration
public class SchedulerConfig {

  private static final String DEFAULT_CRON = "0 0/59 * * * ?";
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
    SimpleScheduleBuilder scheduleBuilder =
        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();

    return TriggerBuilder.newTrigger()
        .forJob(sampleJobDetail())
        .withIdentity("sampleTrigger")
        .withSchedule(scheduleBuilder)
        .build();
  }

  @Bean
  public JobDetail batchAddUsersJobDetail() {

    return JobBuilder.newJob(SimpleJob.class)
        .withIdentity("batchAddUsersJob") // 标识
        .storeDurably()
        .build();
  }

  @Bean
  public Trigger batchAddUsersTrigger() {

    return TriggerBuilder.newTrigger()
        .forJob(batchAddUsersJobDetail())
        .withIdentity("batchAddUsersJobTrigger")
        .withSchedule(CronScheduleBuilder.cronSchedule(CORN_ADD_USER))
        .build();
  }
}
