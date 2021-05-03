package cn.edu.ntu.javaee.springboot.quartz.quickstart.job;

import cn.edu.ntu.javaee.springboot.quartz.quickstart.service.PingService;
import cn.edu.ntu.javaee.springboot.quartz.utils.UTCTimeUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

/**
 * @author zack <br>
 * @create 2020-12-23 21:14 <br>
 * @project springboot <br>
 */
public class SimpleJob extends QuartzJobBean {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleJob.class);
    private static final DateTimeFormatter ofPattern =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Resource PingService pingService;

    private String name;

    /** Invoked if a Job data map entry with that name */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        StringJoiner outStr =
                new StringJoiner(" ")
                        .add(this.getClass().getSimpleName())
                        .add(UTCTimeUtil.localToUtc(LocalDateTime.now()).format(ofPattern))
                        .add(Thread.currentThread().getName())
                        .add(jobExecutionContext.getTrigger().getKey().getName());

        LOG.info("execute quartz job: {}", outStr);
        // LOG.info("execute ping#service in quartz job: {}", pingService.ping());
    }
}
