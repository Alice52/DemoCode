package cn.edu.ntu.springcloud.payment2.service.impl;

import cn.edu.ntu.springcloud.common.entities.Payment;
import cn.edu.ntu.springcloud.payment2.dao.PaymentDao;
import cn.edu.ntu.springcloud.payment2.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2020-03-10 00:50 <br>
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
