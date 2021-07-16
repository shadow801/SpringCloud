package com.yewen.springcloud.alibaba.service;

import com.yewen.springcloud.alibaba.dao.OrderDao;
import com.yewen.springcloud.alibaba.domain.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-14 18:32
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "yewen-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("--->新建订单开始");
        // 新建订单
        orderDao.create(order);

        log.info("--->订单微服务开始调用库存,做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount()); // 扣减库存
        log.info("--->订单微服务开始调用库存,做扣减结束");

        log.info("--->订单微服务开始调用账户,做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney()); // 扣减账户
        log.info("--->订单微服务开始调用账户,做扣减结束");

        log.info("--->修改订单状态开始");
        orderDao.update(order.getUserId(), 0); // 修改订单状态,从0到1,1代表已经完成
        log.info("--->修改订单状态结束");

        log.info("--->下订单结束,O(∩_∩)O~");
    }

}
