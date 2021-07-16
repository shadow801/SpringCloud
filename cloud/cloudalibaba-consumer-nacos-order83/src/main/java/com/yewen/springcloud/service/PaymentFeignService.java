package com.yewen.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ShadowStart
 * @create 2021-07-10 21:46
 */
@FeignClient(value = "${service-url.nacos-user-service}")
//@FeignClient(value = "nacos-payment-provider")
public interface PaymentFeignService {

    @GetMapping("/payment/nacos/{id}")
    String paymentInfo(@PathVariable("id") Integer id);

}
