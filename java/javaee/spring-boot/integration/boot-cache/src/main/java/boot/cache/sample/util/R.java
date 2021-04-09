package boot.cache.sample.util;

import boot.cache.sample.constants.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zack <br>
 * @create 2021-04-09 10:29 <br>
 * @project integration <br>
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class R<T> implements Serializable {
  private static final long serialVersionUID = 1L;

  @Getter @Setter private int code = CommonConstants.SUCCESS;

  @Getter @Setter private String msg = "success";

  @Getter @Setter private T data;

  public R() {
    super();
  }

  public R(T data) {
    super();
    this.data = data;
  }

  public R(T data, String msg) {
    super();
    this.data = data;
    this.msg = msg;
  }

  public R(Throwable e) {
    super();
    this.msg = e.getMessage();
    this.code = CommonConstants.FAIL;
  }
}
