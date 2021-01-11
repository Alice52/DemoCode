package cn.edu.ntu.javaee.springboot.jdbc.model.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zack <br>
 * @create 2021-01-11<br>
 * @project integration <br>
 */
@Data
public class Department {
  private Integer id;
  private String dept_name;
  private String location;
  private LocalDateTime created_date;

  private LocalDateTime updated_date;
  private boolean is_deleted;
}
