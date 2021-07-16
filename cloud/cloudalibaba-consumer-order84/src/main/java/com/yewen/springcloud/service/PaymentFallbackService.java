package com.yewen.springcloud.service;

import com.yewen.springcloud.entities.CommonResult;
import com.yewen.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author ShadowStart
 * @create 2021-07-13 17:11
 */
@Component
public class PaymentFallbackService implements PaymentOpenFeignService {

    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(4444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
