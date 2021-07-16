package com.yewen.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author ShadowStart
 * @create 2021-07-06 21:10
 */
@Service
public class paymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "---------paymentFallbackService fall paymentInfoOK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "---------paymentFallbackService fall paymentInfoTimeout,o(╥﹏╥)o";
    }
}
