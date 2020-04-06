package cn.edu.ntu.springcloud.order1.customlb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zack <br>
 * @create 2020-04-01 21:41 <br>
 */
public interface LoadBalancer {

  ServiceInstance instance(List<ServiceInstance> instances);
}
