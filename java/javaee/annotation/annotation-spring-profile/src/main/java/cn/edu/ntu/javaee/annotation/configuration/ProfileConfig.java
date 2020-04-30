package cn.edu.ntu.javaee.annotation.configuration;

import cn.edu.ntu.javaee.annotation.common.model.Person;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @author zack <br>
 * @create 2020-04-30 19:25 <br>
 */
@PropertySource("classpath:/db.properties")
@Configuration
public class ProfileConfig implements EmbeddedValueResolverAware {

  /**
   * If no profile is specified, it will be loaded regardless of the environment
   *
   * @return Person
   */
  @Bean
  public Person person() {
    return new Person();
  }

  @Value("${db.user}")
  private String user;

  private StringValueResolver valueResolver;
  private String driverClass;

  @Profile("test")
  @Bean("testDataSource")
  public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws Exception {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUsername(user);
    dataSource.setPassword(pwd);
    dataSource.setUrl("jdbc:mysql://localhost:3306/test");
    dataSource.setDriverClassName(driverClass);
    return dataSource;
  }

  @Profile("dev")
  @Bean("devDataSource")
  public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws Exception {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUsername(user);
    dataSource.setPassword(pwd);
    dataSource.setUrl("jdbc:mysql://localhost:3306/dev");
    dataSource.setDriverClassName(driverClass);
    return dataSource;
  }

  @Profile("prod")
  @Bean("prodDataSource")
  public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws Exception {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setUsername(user);
    dataSource.setPassword(pwd);
    dataSource.setUrl("jdbc:mysql://localhost:3306/prod");
    dataSource.setDriverClassName(driverClass);
    return dataSource;
  }

  @Override
  public void setEmbeddedValueResolver(StringValueResolver resolver) {
    this.valueResolver = resolver;
    driverClass = valueResolver.resolveStringValue("${db.driverClass}");
  }
}
