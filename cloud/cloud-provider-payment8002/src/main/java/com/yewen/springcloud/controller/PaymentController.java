package com.yewen.springcloud.controller;

import com.yewen.springcloud.entities.CommonResult;
import com.yewen.springcloud.entities.Payment;
import com.yewen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-02 20:35
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***插入结果:{}", result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据成功,serverPort: "+serverPort, result);
        } else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功,serverPort: "+serverPort, payment);
        } else {
            return new CommonResult<>(444, "没有对应记录，查询ID：" + id, null); // 没有对应近路，查询ID
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi,i`am payment zipkin server fall back.welcome to yewen, O(∩_∩)O~";
    }
}