package com.yewen.springcloud.alibaba.service;

import com.yewen.springcloud.alibaba.domain.Order;
import com.yewen.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ShadowStart
 * @create 2021-07-14 18:34
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @GetMapping(value = "/storage/decrease")
    CommonResult<Order> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
