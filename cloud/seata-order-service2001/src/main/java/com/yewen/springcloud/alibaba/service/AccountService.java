package com.yewen.springcloud.alibaba.service;

import com.yewen.springcloud.alibaba.domain.Order;
import com.yewen.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author ShadowStart
 * @create 2021-07-14 18:35
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @GetMapping(value = "/account/decrease")
    CommonResult<Order> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
