package com.yewen.springcloud.service;

import com.yewen.springcloud.entities.CommonResult;
import com.yewen.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ShadowStart
 * @create 2021-07-13 13:18
 */
@FeignClient(value = "${server-url.nacos-user-service}", fallback = PaymentFallbackService.class)
public interface PaymentOpenFeignService {

    @GetMapping("/paymentSQL/{id}")
    CommonResult<Payment> paymentSql(@PathVariable("id") Long id);

}
