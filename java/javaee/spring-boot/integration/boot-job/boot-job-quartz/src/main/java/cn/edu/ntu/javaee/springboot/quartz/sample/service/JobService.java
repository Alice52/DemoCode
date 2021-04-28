package cn.edu.ntu.javaee.springboot.quartz.sample.service;

import cn.edu.ntu.javaee.springboot.quartz.sample.model.entity.JobAndTrigger;
import cn.edu.ntu.javaee.springboot.quartz.sample.model.vo.JobForm;
import com.github.pagehelper.PageInfo;
import org.quartz.SchedulerException;

import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-04-28<br>
 * @project integration <br>
 */
public interface JobService {
  /**
   * 添加并启动定时任务
   *
   * @param form 表单参数 {@link JobForm}
   * @throws Exception 异常
   */
  void addJob(JobForm form) throws Exception;

  /**
   * 删除定时任务
   *
   * @param form 表单参数 {@link JobForm}
   * @throws SchedulerException 异常
   */
  void deleteJob(JobForm form) throws SchedulerException;

  /**
   * 暂停定时任务
   *
   * @param form 表单参数 {@link JobForm}
   * @throws SchedulerException 异常
   */
  void pauseJob(JobForm form) throws SchedulerException;

  /**
   * 恢复定时任务
   *
   * @param form 表单参数 {@link JobForm}
   * @throws SchedulerException 异常
   */
  void resumeJob(JobForm form) throws SchedulerException;

  /**
   * 重新配置定时任务
   *
   * @param form 表单参数 {@link JobForm}
   * @throws Exception 异常
   */
  void cronJob(JobForm form) throws Exception;

  /**
   * 查询定时任务列表
   *
   * @param currentPage 当前页
   * @param pageSize 每页条数
   * @return 定时任务列表
   */
  PageInfo<JobAndTrigger> list(Integer currentPage, Integer pageSize);

  /**
   * 获取所有可操作的Job对象
   *
   * @return
   */
  Map<String, String> listAllAvailableJobs();
}
