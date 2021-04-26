package boot.job.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zack <br>
 * @create 2021-04-26 09:43 <br>
 * @project boot-job-quartz <br>
 */
@SpringBootApplication
public class SchedulerApplication {

  public static void main(String[] args) {

    SpringApplication.run(SchedulerApplication.class, args);
  }
}
