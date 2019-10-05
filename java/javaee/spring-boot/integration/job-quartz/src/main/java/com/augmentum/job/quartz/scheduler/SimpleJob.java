package com.augmentum.job.quartz.scheduler;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author zack
 * @create 2019-09-22 1:00
 * @function simple quartz job
 */
public class SimpleJob extends QuartzJobBean {

  private String name;

  // Invoked if a Job data map entry with that name
  public void setName(String name) {
    this.name = name;
  }

  @Override
  protected void executeInternal(JobExecutionContext context) {
    System.out.println(Thread.currentThread().getName() + String.format("Hello %s!", this.name));
  }
}
