package cn.edu.ntu.mq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zack <br>
 * @create 2021-03-07 00:16 <br>
 * @project mq <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Person {

    private String name;
    private Integer age;
}
