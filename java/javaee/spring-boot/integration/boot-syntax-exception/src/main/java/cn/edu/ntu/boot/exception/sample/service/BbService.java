package cn.edu.ntu.boot.exception.sample.service;

import javax.validation.constraints.NotNull;

/**
 * @author zack <br>
 * @create 2021-04-25 13:09 <br>
 * @project integration <br>
 */
public interface BbService {
  /**
   * say hello to name.
   *
   * @param name
   */
  void helloB(@NotNull(message = "名称不能为空")String name);

  /**
   * A service will call this api to handle logic.
   *
   * @param name
   */
  void hello4A(@NotNull(message = "名称不能为空") String name);
}
