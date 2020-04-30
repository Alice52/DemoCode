package cn.edu.ntu.javaee.annotation.interf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zack <br>
 * @create 2020-04-30 12:13 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class Dog implements InitializingBean, DisposableBean {
  private Integer age;
  private String name;
  private String color;

  @PostConstruct
  public void init1() {
    log.info("2. Person object init1 method execute.");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("3. Person object afterPropertiesSet method execute.");
  }

  public void init() {
    log.info("4. Person object init method execute.");
  }

  @PreDestroy
  public void destroy1() {
    log.info("6. Person object destroy1 method execute.");
  }

  @Override
  public void destroy() throws Exception {
    log.info("7. Person object destroy[DisposableBean] method execute.");
  }

  public void destroy0() {
    log.info("8. Person object destroy0 method execute.");
  }
}
