package com.yewen.springcloud.alibaba.dao;

import com.yewen.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ShadowStart
 * @create 2021-07-14 17:25
 */
@Mapper
public interface OrderDao {

    // 新建订单
    void create(Order order);

    // 修改订单状态,从0改为1
    void update(@Param("userId") Long id, @Param("status") Integer status);
}
