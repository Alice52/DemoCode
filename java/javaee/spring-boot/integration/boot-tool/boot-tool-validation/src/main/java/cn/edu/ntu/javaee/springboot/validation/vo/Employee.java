package cn.edu.ntu.javaee.springboot.validation.vo;

import cn.edu.ntu.javaee.springboot.validation.annotation.Mobile;
import cn.edu.ntu.javaee.springboot.validation.annotation.validation.Add;
import cn.edu.ntu.javaee.springboot.validation.annotation.validation.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * if do not specify group, it will belongs to Default group.
 *
 * <p>then we can specify group to validation when used.
 *
 * @author zack <br>
 * @create 2020-08-01 18:33 <br>
 * @project validation <br>
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {

    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    private Integer id;

    @ApiModelProperty(required = true)
    @NotEmpty
    private String name;

    /**
     * This just validate {@link Department} when it is not null, <br>
     * If {@link Department} is null, it can go though validation such as @Email.
     */
    @Valid private Department department;

    @Mobile private String phone;

    /** This is EL expression, but value is hard code 18. */
    @Min(value = 18, message = "{value} is invalid")
    private Integer age;
}
