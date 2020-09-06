package cn.edu.ntu.javaee.springboot.validation.controller;

import cn.edu.ntu.javaee.springboot.validation.annotation.ValidList;
import cn.edu.ntu.javaee.springboot.validation.annotation.validation.Add;
import cn.edu.ntu.javaee.springboot.validation.annotation.validation.Update;
import cn.edu.ntu.javaee.springboot.validation.common.ErrorResponse;
import cn.edu.ntu.javaee.springboot.validation.vo.Coder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

/**
 * Do not do any validation for parameters, and do it in service.
 *
 * @author zack <br>
 * @create 2020-08-01 18:39 <br>
 * @project validation <br>
 */
@ApiResponses({
  @ApiResponse(code = 400, message = "Internal Error", response = ErrorResponse.class)
})
@Api
@Validated
@RestController
@RequestMapping("/coder")
public class CoderController {

  /**
   * This will not validate the parameter of title about level.
   *
   * <p>Unless add Default.class due to <code>
   * CoderGroupSequenceProvider implements DefaultGroupSequenceProvider<Coder></code> <br>
   * it add group to default groups.
   *
   * @param coderList
   * @return
   */
  @PostMapping("/list")
  public Object addList(
      @RequestBody @ValidList(values = {Add.class, Coder.Common.class}) List<Coder> coderList) {

    return "ok";
  }

  /**
   * <code>@Valid</code> cannot specify group info, and it will validate Default.class. <br>
   * and it will cannot show all error message.
   *
   * @param coderList
   * @return
   */
  @PostMapping("/list-directly")
  public Object addListDirectly(@RequestBody List<@Valid Coder> coderList) {

    return "ok";
  }

  /**
   * This validation will cannot show error message combined with other provider.
   *
   * <p>so, if we want show all error message, please donot use Default.class in model, and should
   * add Default.class to group. <br>
   * and if no Coder.Common.class, it will not show title level validate message together. <br>
   * <code>@NotNull(groups = {Common.class})</code>
   *
   * @param coder
   * @return
   */
  @PutMapping
  public Object update(
      @RequestBody @Validated({Update.class, Coder.Common.class, Default.class}) Coder coder) {

    return "ok";
  }

  @PostMapping
  public Object add(@RequestBody @Valid Coder coder) {

    return "ok";
  }
}
