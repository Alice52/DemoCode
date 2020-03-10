package cn.edu.ntu.springcloud.payment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack <br>
 * @create 2020-03-10 00:27 <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {

  private Integer code;
  private String message;

  private T data;

  public JsonResult(Integer code, String message) {
   this(code, message, null);
  }
}
