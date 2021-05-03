package boot.cache.lock.model;

import lombok.*;

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
