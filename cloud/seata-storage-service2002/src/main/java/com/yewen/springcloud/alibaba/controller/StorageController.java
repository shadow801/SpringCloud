package com.yewen.springcloud.alibaba.controller;

import com.yewen.springcloud.alibaba.domain.Storage;
import com.yewen.springcloud.alibaba.service.StorageService;
import com.yewen.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-14 20:56
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping("/storage/decrease")
    public CommonResult<Storage> decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult<>(200, "扣减库存成功");
    }

}
