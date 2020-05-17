package cn.edu.ntu.javaee.springboot.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack <br>
 * @create 2020-05-17 16:34 <br>
 * @project springboot <br>
 */
@Configuration
@ConfigurationProperties(prefix = "stater.hello")
public class HelloProperties {

  private String prefix;
  private String suffix;

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }
}
