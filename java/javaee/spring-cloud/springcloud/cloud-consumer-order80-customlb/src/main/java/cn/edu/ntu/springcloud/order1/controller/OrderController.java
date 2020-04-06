package cn.edu.ntu.springcloud.order1.controller;

import cn.edu.ntu.springcloud.common.entities.JsonResult;
import cn.edu.ntu.springcloud.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import cn.edu.ntu.springcloud.order1.customlb.CustomLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zack <br>
 * @create 2020-03-10 21:42 <br>
 */
@RestController
@Slf4j
@RequestMapping(value = "/consumer")
public class OrderController {

  private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT-SERVICE";
  @Resource private RestTemplate restTemplate;
  @Resource private DiscoveryClient discoveryClient;
  @Resource private CustomLoadBalancer customLoadBalancer;

  @GetMapping(value = "/payment/create")
  public JsonResult<Payment> create(Payment payment) {

    return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, JsonResult.class);
  }

  @GetMapping(value = "/payment/get/{id}")
  public JsonResult getPaymentById(@PathVariable("id") Long id) {
    return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, JsonResult.class);
  }

  @GetMapping(value = "/payment/getEntity/{id}")
  public JsonResult getPaymentById2(@PathVariable("id") Long id) {
    return new JsonResult(
        200, "ok", restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, JsonResult.class));
  }

  @GetMapping(value = "/payment/lb")
  public JsonResult getPaymentLB() {

    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

    AtomicReference<ServiceInstance> instance = new AtomicReference<>();
    Optional.ofNullable(instances)
        .ifPresent(
            x -> {
              instance.set(customLoadBalancer.instance(x));
            });

    URI uri = instance.get().getUri();
    return restTemplate.getForObject(uri + "/payment/lb/", JsonResult.class);
  }
}
