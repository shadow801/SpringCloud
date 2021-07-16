package com.yewen.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ShadowStart
 * @create 2021-07-06 18:04
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfoOK, id: " + id + "\tO(∩_∩)O";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentInfoTimeout(Integer id) {
//        int i = 10 / 0;
        int Timeout = 3;
        try { TimeUnit.SECONDS.sleep(Timeout); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池： " + Thread.currentThread().getName() + " PaymentInfoTimeout, id: " + id + "\tO(∩_∩)O" + "耗时"+ Timeout +"秒钟";
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " 系统繁忙或者运行报错，请稍后再试, id: " + id + "\to(╥﹏╥)o";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Integer id) {
        return "id 不能为负数，请稍后再试，/(ㄒoㄒ)/~~ id: " + id;
    }


}
