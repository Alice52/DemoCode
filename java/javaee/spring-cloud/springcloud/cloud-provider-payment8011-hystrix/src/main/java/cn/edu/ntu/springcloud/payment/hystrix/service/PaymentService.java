package cn.edu.ntu.springcloud.payment.hystrix.service;

/**
 * the two method will aslo become slow due to high concurrent<br>
 *
 * @author zack <br>
 * @create 2020-04-02 22:30 <br>
 */
public interface PaymentService {

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
}
