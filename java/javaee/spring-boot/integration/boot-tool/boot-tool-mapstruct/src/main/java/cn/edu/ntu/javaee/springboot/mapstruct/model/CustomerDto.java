package cn.edu.ntu.javaee.springboot.mapstruct.model;

import lombok.Data;

/**
 * @author zack <br>
 * @create 2020-11-08 23:46 <br>
 * @project springboot <br>
 */
@Data
public class CustomerDto {
    private Long id;
    private String customerName;
    private String disable;
}
