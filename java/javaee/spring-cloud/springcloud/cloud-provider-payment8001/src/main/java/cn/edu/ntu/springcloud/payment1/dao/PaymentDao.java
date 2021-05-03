package cn.edu.ntu.springcloud.payment1.dao;

import cn.edu.ntu.springcloud.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zack <br>
 * @create 2020-03-10 00:31 <br>
 */
@Mapper
public interface PaymentDao {
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
