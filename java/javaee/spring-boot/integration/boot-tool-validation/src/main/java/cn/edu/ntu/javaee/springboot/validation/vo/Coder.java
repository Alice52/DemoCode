package cn.edu.ntu.javaee.springboot.validation.vo;

import cn.edu.ntu.javaee.springboot.validation.annotation.validation.Add;
import cn.edu.ntu.javaee.springboot.validation.annotation.validation.Update;
import cn.edu.ntu.javaee.springboot.validation.provider.CoderGroupSequenceProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;

/**
 * 举例<br>
 * 1. 员工的 age 在 20-25 之间, title 必须以 "初级" 开头<br>
 * 2. 员工的 age 在 25-30 之间, title 必须以 "中级" 开头 <br>
 * 3. 否则, 做验证<br>
 * if we want validate title, this group is required: Default.class if we want show error message
 * with other validator, it will need @NotNull(groups = {Common.class})[cannot be Default.class],
 * and it must be included in groups.
 *
 * @author zack <br>
 * @create 2020-08-02 12:16 <br>
 * @project validation <br>
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@GroupSequenceProvider(CoderGroupSequenceProvider.class)
public class Coder {

  @NotNull(groups = {Common.class, Default.class})
  private Integer age;

  @Null(
      groups = {Update.class},
      message = "cannot update name")
  @NotBlank(
      groups = {Add.class},
      message = "name must be not blank")
  private String name;

  @NotNull(groups = {Common.class, Default.class})
  private String company;

  /** 初级 */
  @Pattern(
      regexp = "^\u521d\u7ea7.*",
      groups = {PrimaryCoder.class})
  /** 中级 */
  @Pattern(
      regexp = "^\u4e2d\u7ea7.*",
      groups = {MiddleCoder.class})
  private String title;

  /** this is customized default group, if has Default.class, should add Common.class */
  public interface Common {}

  public interface PrimaryCoder {};

  public interface MiddleCoder {};
}
