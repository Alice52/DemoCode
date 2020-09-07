package cn.edu.ntu.json.model;

import lombok.*;

/**
 * @author zack <br>
 * @create 2020-09-07 23:35 <br>
 * @project json <br>
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
