package cn.edu.ntu.javaee.mvc.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-05-01 22:26 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class User {

  private Integer age;
  private String name;
}
