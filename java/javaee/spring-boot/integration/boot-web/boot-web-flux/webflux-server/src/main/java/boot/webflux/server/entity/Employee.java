package boot.webflux.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author zack <br>
 * @create 2021-04-11 14:28 <br>
 * @project springboot <br>
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id private String id;

    private String name;

    private Integer age;
}
