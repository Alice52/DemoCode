package cn.edu.ntu.springcloud.gateway.filter;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zack <br>
 * @create 2020-04-09 21:47 <br>
 */
@Component
public class CustomFilter implements GlobalFilter, Ordered {
  private static final Logger LOG = LoggerFactory.getLogger(CustomFilter.class);

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

    String name = exchange.getRequest().getQueryParams().getFirst("name");

    if (StrUtil.isBlank(name)) {
      exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
      return exchange.getResponse().setComplete();
    }

    return chain.filter(exchange);
  }

  /**
   * the sequence of execute filter. <br>
   * The smaller the value, the higher the priority
   *
   * @return sequence
   */
  @Override
  public int getOrder() {
    return 0;
  }
}
