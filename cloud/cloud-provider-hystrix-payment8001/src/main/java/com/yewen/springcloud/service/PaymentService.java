package com.yewen.springcloud.service;

/**
 * @author ShadowStart
 * @create 2021-07-06 18:02
 */
public interface PaymentService {

    String paymentInfoOK(Integer id);

    String paymentInfoTimeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
