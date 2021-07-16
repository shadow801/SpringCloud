package com.yewen.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author ShadowStart
 * @create 2021-07-14 21:33
 */
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);

}
