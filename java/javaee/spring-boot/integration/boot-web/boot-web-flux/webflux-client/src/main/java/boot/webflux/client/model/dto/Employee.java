package boot.webflux.client.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zack <br>
 * @create 2021-04-11 14:28 <br>
 * @project springboot <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String id;

    private String name;

    private Integer age;
}
