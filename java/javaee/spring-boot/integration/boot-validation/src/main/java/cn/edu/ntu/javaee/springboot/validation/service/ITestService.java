package cn.edu.ntu.javaee.springboot.validation.service;

import cn.edu.ntu.javaee.springboot.validation.vo.UserVO;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author zack <br>
 * @create 2020-07-28 20:57 <br>
 * @project jsr303 <br>
 */
@Validated
public interface ITestService {

  String validate(@Email String email);

  UserVO register(@Valid UserVO userVO);

  String validateBetweenService(@Email String email) throws Exception;

  Object hello(@NotNull @Min(10) Integer id, @NotNull String name);
}
