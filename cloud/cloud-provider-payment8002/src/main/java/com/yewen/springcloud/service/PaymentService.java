package com.yewen.springcloud.service;

import com.yewen.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author ShadowStart
 * @create 2021-07-02 20:30
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
