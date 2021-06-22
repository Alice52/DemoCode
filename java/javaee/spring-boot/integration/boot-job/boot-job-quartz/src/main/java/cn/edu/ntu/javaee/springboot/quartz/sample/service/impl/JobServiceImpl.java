package cn.edu.ntu.javaee.springboot.quartz.sample.service.impl;

import cn.edu.ntu.javaee.springboot.quartz.sample.job.BaseJob;
import cn.edu.ntu.javaee.springboot.quartz.sample.mapper.JobMapper;
import cn.edu.ntu.javaee.springboot.quartz.sample.model.entity.JobAndTrigger;
import cn.edu.ntu.javaee.springboot.quartz.sample.model.vo.JobForm;
import cn.edu.ntu.javaee.springboot.quartz.sample.service.JobService;
import cn.edu.ntu.javaee.springboot.quartz.sample.util.JobUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zack <br>
 * @create 2021-04-28<br>
 * @project integration <br>
 */
@Service
@Slf4j
public class JobServiceImpl implements JobService {

    @Resource private Scheduler scheduler;
    @Resource private JobMapper jobMapper;
    @Resource private List<BaseJob> jobs;

    /**
     * 添加并启动定时任务
     *
     * @param form 表单参数 {@link JobForm}
     * @return {@link JobDetail}
     * @throws Exception 异常
     */
    @Override
    public void addJob(JobForm form) throws Exception {
        // 启动调度器
        scheduler.start();

        // 构建Job信息
        JobDetail jobDetail =
                JobBuilder.newJob(JobUtil.getClass(form.getJobClassName()).getClass())
                        .withIdentity(form.getJobClassName(), form.getJobGroupName())
                        .build();

        // Cron表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder cron = CronScheduleBuilder.cronSchedule(form.getCronExpression());

        // 根据Cron表达式构建一个Trigger
        CronTrigger trigger =
                TriggerBuilder.newTrigger()
                        .withIdentity(form.getJobClassName(), form.getJobGroupName())
                        .withSchedule(cron)
                        .build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            log.error("【定时任务】创建失败！", e);
            throw new Exception("【定时任务】创建失败！");
        }
    }

    /**
     * 删除定时任务
     *
     * @param form 表单参数 {@link JobForm}
     * @throws SchedulerException 异常
     */
    @Override
    public void deleteJob(JobForm form) throws SchedulerException {
        scheduler.pauseTrigger(
                TriggerKey.triggerKey(form.getJobClassName(), form.getJobGroupName()));
        scheduler.unscheduleJob(
                TriggerKey.triggerKey(form.getJobClassName(), form.getJobGroupName()));
        scheduler.deleteJob(JobKey.jobKey(form.getJobClassName(), form.getJobGroupName()));
    }

    /**
     * 暂停定时任务
     *
     * @param form 表单参数 {@link JobForm}
     * @throws SchedulerException 异常
     */
    @Override
    public void pauseJob(JobForm form) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(form.getJobClassName(), form.getJobGroupName()));
    }

    /**
     * 恢复定时任务
     *
     * @param form 表单参数 {@link JobForm}
     * @throws SchedulerException 异常
     */
    @Override
    public void resumeJob(JobForm form) throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey(form.getJobClassName(), form.getJobGroupName()));
    }

    /**
     * 重新配置定时任务
     *
     * @param form 表单参数 {@link JobForm}
     * @throws Exception 异常
     */
    @Override
    public void cronJob(JobForm form) throws Exception {
        try {
            TriggerKey triggerKey =
                    TriggerKey.triggerKey(form.getJobClassName(), form.getJobGroupName());
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder =
                    CronScheduleBuilder.cronSchedule(form.getCronExpression());

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            // 根据Cron表达式构建一个Trigger
            trigger =
                    trigger.getTriggerBuilder()
                            .withIdentity(triggerKey)
                            .withSchedule(scheduleBuilder)
                            .build();

            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            log.error("【定时任务】更新失败！", e);
            throw new Exception("【定时任务】创建失败！");
        }
    }

    /**
     * 查询定时任务列表
     *
     * @param currentPage 当前页
     * @param pageSize 每页条数
     * @return 定时任务列表
     */
    @Override
    public PageInfo<JobAndTrigger> list(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<JobAndTrigger> list = jobMapper.list();
        return new PageInfo<>(list);
    }

    @Override
    public Map<String, String> listAllAvailableJobs() {

        Map<String, String> map =
                jobs.stream()
                        .map(x -> x.getClass().getName())
                        .collect(
                                Collectors.toMap(
                                        x -> {
                                            String[] split = StrUtil.split(x, StrUtil.DOT);
                                            return split[split.length - 1];
                                        },
                                        Function.identity()));

        map.forEach((k, v) -> log.info("k: {}, v: {}", k, v));

        return map;
    }

    @Override
    public void triggerManual() throws SchedulerException {

        JobKey jobKey =
                JobKey.jobKey(
                        "cn.edu.ntu.javaee.springboot.quartz.sample.job.DailyEmailJob", "auto");

        scheduler.triggerJob(jobKey);
    }
}
