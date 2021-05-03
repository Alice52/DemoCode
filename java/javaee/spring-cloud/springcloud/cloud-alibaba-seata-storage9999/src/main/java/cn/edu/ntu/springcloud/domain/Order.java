package cn.edu.ntu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zack <br>
 * @create 2020-04-18 20:39 <br>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private Integer status;
    private BigDecimal money;
}
