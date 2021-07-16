package com.yewen.springcloud.controller;

import com.yewen.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-10 21:36
 */
@RestController
public class OrderNacosController {

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo(id);
    }

}
