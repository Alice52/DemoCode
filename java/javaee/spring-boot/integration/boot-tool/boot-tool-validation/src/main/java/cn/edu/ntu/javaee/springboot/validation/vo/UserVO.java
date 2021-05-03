package cn.edu.ntu.javaee.springboot.validation.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * @author zack <br>
 * @create 2020-07-27 22:00 <br>
 * @project jsr303 <br>
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserVO {

    @Max(100)
    @Min(0)
    private Integer age;

    @JsonIgnore @DateTimeFormat private LocalDateTime registerDate;

    @NotBlank private String name;
    @NotBlank @JsonIgnore private String password;

    /** @Email cannot validate null, if email is null, which can go though validation rule. */
    @NotNull @Email private String email;
}
