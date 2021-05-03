package cn.edu.ntu.javaee.springboot.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zack <br>
 * @create 2020-11-08 23:26 <br>
 * @project springboot <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Education {
    private String degreeName;
    private String institute;
    private Integer yearOfPassing;
}
