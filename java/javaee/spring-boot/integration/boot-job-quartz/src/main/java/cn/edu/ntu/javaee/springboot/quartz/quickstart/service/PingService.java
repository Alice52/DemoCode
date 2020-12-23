package cn.edu.ntu.javaee.springboot.quartz.quickstart.service;

/**
 * @author zack <br>
 * @create 2020-12-23 21:17 <br>
 * @project springboot <br>
 */
import org.springframework.stereotype.Service;

@Service
public class PingService {

  public String ping() {
    return "pong";
  }
}
