package cn.edu.ntu.springcloud.payment.hystrix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * the two method will aslo become slow due to high concurrent<br>
 *
 * @author zack <br>
 * @create 2020-04-02 22:30 <br>
 */
@Service
public interface PaymentService {

    Logger LOG = LoggerFactory.getLogger(PaymentService.class);

    /**
     * this service is mock success call.<br>
     *
     * @param id
     * @return String
     */
    String getPaymentInfo(String id);

    /**
     * this service is mock failed call.<br>
     *
     * @param id
     * @return String
     * @throws InterruptedException
     */
    String getPaymentInfoTimeout(String id) throws InterruptedException;

    /**
     * this service is mock failed call.<br>
     *
     * @param id
     * @return String
     * @throws InterruptedException
     */
    String getPaymentInfoError(String id) throws InterruptedException;
}
