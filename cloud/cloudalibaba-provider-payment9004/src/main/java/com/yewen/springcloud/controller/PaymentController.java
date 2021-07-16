package com.yewen.springcloud.controller;

import com.yewen.springcloud.entities.CommonResult;
import com.yewen.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author ShadowStart
 * @create 2021-07-13 12:54
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    public static HashMap<Long, Payment> map = new HashMap<>();
    static {
        map.put(1L, new Payment(1L, UUID.randomUUID().toString()));
        map.put(2L, new Payment(2L, UUID.randomUUID().toString()));
        map.put(3L, new Payment(3L, UUID.randomUUID().toString()));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        return new CommonResult<>(200, "form mysql, server port: " + serverPort, payment);
    }

}
