package boot.webflux.client.common.beans;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author zack <br>
 * @create 2021-04-11 17:13 <br>
 * @project springboot <br>
 */
@Data
@Accessors(fluent = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ServerInfo {

    private String uri;
}
