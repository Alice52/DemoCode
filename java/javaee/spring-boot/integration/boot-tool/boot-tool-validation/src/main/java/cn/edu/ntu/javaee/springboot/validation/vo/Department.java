package cn.edu.ntu.javaee.springboot.validation.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zack <br>
 * @create 2020-08-01 18:33 <br>
 * @project validation <br>
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Department {

    @Null(message = "主键不可以有值")
    private Integer id;

    @ApiModelProperty(required = true, hidden = true)
    @NotNull
    private Integer parentId;

    @NotBlank private String name;

    @NotNull @PastOrPresent private LocalDateTime createTime;

    private List<@Valid Employee> employeeList;
}
