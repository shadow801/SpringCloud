package com.yewen.springcloud.alibaba.service;

/**
 * @author ShadowStart
 * @create 2021-07-14 20:48
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);

}
