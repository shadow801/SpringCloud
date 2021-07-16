package com.yewen.springcloud.controller;

import com.yewen.springcloud.entities.CommonResult;
import com.yewen.springcloud.entities.Payment;
import com.yewen.springcloud.service.PaymentOpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-13 13:17
 */
@RestController
public class OrderController {

    @Resource
    private PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return paymentOpenFeignService.paymentSql(id);
    }
}
