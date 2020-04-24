package cn.edu.ntu.jdbc.sample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zack <br>
 * @create 2020-04-22 13:18 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SerialModel {

  private Long id;
  private String serial;
}
