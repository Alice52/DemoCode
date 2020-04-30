package cn.edu.ntu.javaee.annotation;

import cn.edu.ntu.javaee.annotation.configuration.ProfileConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2020-04-30 19:30 <br>
 */
@Slf4j
public class ProfileTest {
  @Test
  public void test01() {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext();
    // 1. 创建一个applicationContext
    // 2. 设置需要激活的环境
    applicationContext.getEnvironment().setActiveProfiles("dev");
    // 3. 注册主配置类
    applicationContext.register(ProfileConfig.class);
    // 4. 启动刷新容器
    applicationContext.refresh();

    String[] names = applicationContext.getBeanNamesForType(DataSource.class);
    Arrays.stream(names).forEach(System.out::println);

    applicationContext.close();
  }
}
