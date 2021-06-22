package cn.edu.ntu.javaee.springboot.quartz.quickstart.configration;

import cn.edu.ntu.javaee.springboot.quartz.quickstart.job.SimpleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
@Configuration
public class SchedulerConfig {

    private static final String DEFAULT_CRON = "* * * * * ? 2012,2020,2025";
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
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(2)
                                .repeatForever())
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
        // CronScheduleBuilder cronScheduleBuilder =
        // CronScheduleBuilder.cronSchedule(CORN_ADD_USER);
        Trigger trigger =
                SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever()
                        .build();

        List<Trigger> collect =
                Stream.of(trigger)
                        .filter(
                                x ->
                                        !(x instanceof CronTrigger)
                                                || x.getFireTimeAfter(new Date()) != null)
                        .collect(Collectors.toList());

        return TriggerBuilder.newTrigger()
                .forJob("batchAddUsersJob")
                .withIdentity("batchAddUsersJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(CORN_ADD_USER))
                .build();
    }
}
