package cn.edu.ntu.javaee.springboot.quartz.quickstart.component;

import cn.edu.ntu.javaee.springboot.quartz.quickstart.job.SimpleJob;
import org.quartz.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Recommend.
 *
 * <p>This sample is using scheduler to schedule job manually.
 *
 * @see cn.edu.ntu.javaee.springboot.quartz.quickstart.configration.SchedulerConfig
 * @author zack <br>
 * @create 2020-12-23 21:21 <br>
 * @project springboot <br>
 */
// @Component
public class JobInit {

  @Resource Scheduler scheduler;

  @PostConstruct
  public void initJob() throws SchedulerException {
    JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("simple-job").build();
    Trigger trigger =
        TriggerBuilder.newTrigger()
            .withIdentity("simple-trigger")
            .withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
            .build();

    scheduler.scheduleJob(jobDetail, trigger);
  }
}
