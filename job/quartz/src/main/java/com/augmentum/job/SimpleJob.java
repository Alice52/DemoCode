package com.augmentum.job;

import com.augmentum.job.utils.UTCTimeUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zack
 * @create 2019-09-21 20:15
 * @function it is a simple job to output in console.
 */
public class SimpleJob implements Job {

  private static final Logger LOG = LoggerFactory.getLogger(SimpleJob.class);

  @Override
  public void execute(JobExecutionContext jobExecutionContext) {

    LocalDateTime now = UTCTimeUtil.localToUtc(LocalDateTime.now());
    DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String dataString = now.format(ofPattern);
    // Job: output to console
    LOG.info("execute quartz job: the utc time is : " + dataString);
  }
}
