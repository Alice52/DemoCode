package cn.edu.ntu.javaee.springboot.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zack <br>
 * @create 2020-11-08 23:46 <br>
 * @project springboot <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private Boolean isDisable;
}
