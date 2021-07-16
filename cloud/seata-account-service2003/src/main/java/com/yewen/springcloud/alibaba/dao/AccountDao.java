package com.yewen.springcloud.alibaba.dao;

import com.yewen.springcloud.alibaba.domain.Account;
import com.yewen.springcloud.entities.CommonResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;


/**
 * @author ShadowStart
 * @create 2021-07-14 21:14
 */
@Mapper
public interface AccountDao {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
