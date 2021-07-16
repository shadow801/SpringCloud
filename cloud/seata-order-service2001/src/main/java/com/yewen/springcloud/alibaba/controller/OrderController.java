package com.yewen.springcloud.alibaba.controller;

import com.yewen.springcloud.alibaba.domain.Order;
import com.yewen.springcloud.alibaba.service.OrderService;
import com.yewen.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-14 19:13
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Order> createOrder(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "订单创建成功");
    }

}
