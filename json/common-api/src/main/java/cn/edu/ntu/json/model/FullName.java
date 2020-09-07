package cn.edu.ntu.json.model;

import lombok.*;

/**
 * @author zack <br>
 * @create 2020-09-07 21:20 <br>
 * @project json <br>
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class FullName {
  private String firstName;
  private String middleName;
  private String lastName;
}
