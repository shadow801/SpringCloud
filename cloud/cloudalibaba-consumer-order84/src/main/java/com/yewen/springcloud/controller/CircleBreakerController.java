package com.yewen.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yewen.springcloud.entities.CommonResult;
import com.yewen.springcloud.entities.Payment;

import com.yewen.springcloud.service.PaymentOpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-13 13:41
 */
@RestController
public class CircleBreakerController {

    @Resource
    private PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback") // fallback只负责业务异常
//    @SentinelResource(value= "fallback", blockHandler = "handlerFallback") // blackHandler只负责控制台配置问题
    @SentinelResource(value= "fallback", fallback = "handlerFallback",  blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class}) // 如果同时出现两种问题，只会进入blockHandler
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> commonResult = paymentOpenFeignService.paymentSql(id);
        if (4 == id) {
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常");
        } else if(null == commonResult.getData()) {
            throw new NullPointerException("NullPointerException，该ID没有对应记录，空指针异常");
        }
        return commonResult;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable e) {
        return new CommonResult<>(444, "此处为应急方案handlerFallback，exception内容:" + e.getMessage(), new Payment(id, "null"));
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException e) {
        return new CommonResult<>(445, "此处为应急方案blockHandler，exception内容:" + e.getMessage(), new Payment(id, "null"));
    }
}
