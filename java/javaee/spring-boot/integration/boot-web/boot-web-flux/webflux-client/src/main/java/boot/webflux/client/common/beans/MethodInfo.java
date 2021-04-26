package boot.webflux.client.common.beans;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-04-11 17:18 <br>
 * @project springboot <br>
 */
@Data
@Accessors
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MethodInfo {

  private String uri;
  private HttpMethod method;

  private Map<String, Object> params;

  private Mono<?> body;
  private Class<?> bodyType;

  private Boolean isFlux;
  private Class<?> returnType;
}
