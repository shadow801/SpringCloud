package com.yewen.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yewen.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-06 19:18
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoOK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        String result = paymentHystrixService.paymentInfoTimeout(id);
        return result;
    }

    public String paymentInfoTimeoutHandler(@PathVariable("id") Integer id) { // fallback的方法形参必须与调用自己的方法形参一致，否者会找不到报错
        return "我是消费者80，对方支付系统繁忙，请10秒钟后再试或则自己运行出错请检查自己o(╥﹏╥)o";
    }

    /**
     * 全局fallback方法
     */
    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试，o(╥﹏╥)o";
    }

}
