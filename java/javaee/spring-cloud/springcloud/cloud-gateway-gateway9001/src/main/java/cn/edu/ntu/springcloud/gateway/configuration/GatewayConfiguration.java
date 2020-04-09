package cn.edu.ntu.springcloud.gateway.configuration;

import cn.hutool.core.util.IdUtil;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zack <br>
 * @create 2020-04-08 23:50 <br>
 */
@Configuration
public class GatewayConfiguration {

  @Bean
  public RouteLocator routes(RouteLocatorBuilder builder) {
    RouteLocatorBuilder.Builder routes = builder.routes();
    routes
        .route(IdUtil.simpleUUID(), r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
        .build();

    routes
        .route(IdUtil.simpleUUID(), r -> r.path("/guoji").uri("http://news.baidu.com/guoji"))
        .build();

    return routes.build();
  }
}
