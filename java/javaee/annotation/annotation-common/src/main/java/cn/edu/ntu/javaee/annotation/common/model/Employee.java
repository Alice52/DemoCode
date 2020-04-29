package cn.edu.ntu.javaee.annotation.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zack <br>
 * @create 2020-04-29 21:36 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
  private Integer age;
  private String name;
  private String Company;
}
