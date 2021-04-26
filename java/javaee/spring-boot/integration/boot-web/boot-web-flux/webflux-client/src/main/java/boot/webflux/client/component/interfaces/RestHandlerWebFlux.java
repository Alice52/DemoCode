package boot.webflux.client.component.interfaces;

import boot.webflux.client.common.beans.MethodInfo;
import boot.webflux.client.common.beans.ServerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author zack <br>
 * @create 2021-04-11 18:05 <br>
 * @project springboot <br>
 */
@Slf4j
@Component
public class RestHandlerWebFlux implements IRestHandler {

  private WebClient client;

  @Override
  public Object invokeRest(MethodInfo methodInfo) {

    Object result;

    log.info("method info: {}", methodInfo);

    WebClient.RequestBodySpec r =
        this.client
            .method(methodInfo.getMethod())
            .uri(methodInfo.getUri(), methodInfo.getParams())
            .accept(MediaType.APPLICATION_JSON);

    if (methodInfo.getBody() != null) {
      r.body(methodInfo.getBody(), methodInfo.getBodyType());
    }

    WebClient.ResponseSpec request = r.retrieve();
    if (methodInfo.getIsFlux()) {
      result = request.bodyToFlux(methodInfo.getReturnType());
    } else {
      result = request.bodyToMono(methodInfo.getReturnType());
    }

    return result;
  }

  @Override
  public void initServerInfo(ServerInfo info) {

    client = WebClient.create(info.uri());
  }
}
