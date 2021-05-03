package cn.edu.ntu.springcloud.payment2.service;

import cn.edu.ntu.springcloud.common.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zack <br>
 * @create 2020-03-10 00:49 <br>
 */
public interface PaymentService {
    /**
     * Create payment record. <br>
     *
     * @param payment entity
     * @return id
     */
    int create(Payment payment);

    /**
     * Get Payment info by id. <br>
     *
     * @param id pk
     * @return Payment by id
     */
    Payment getPaymentById(@Param("id") Long id);
}
