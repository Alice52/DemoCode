package boot.cache.model;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2021-01-04 22:22 <br>
 * @project springboot <br>
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private String name = "zack";
  private Integer age = 18;
}
