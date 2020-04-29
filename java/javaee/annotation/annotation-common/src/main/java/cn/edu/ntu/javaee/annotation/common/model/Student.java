package cn.edu.ntu.javaee.annotation.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zack <br>
 * @create 2020-04-29 22:06 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
  private Integer age;
  private String name;
  private String school;
}
