package com.yewen.springcloud.alibaba.service;

import com.yewen.springcloud.alibaba.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-14 20:51
 */
@Service
public class StorageServiceImpl implements StorageService {

    public static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("-->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        LOGGER.info("-->storage-service中扣减库存结束");
    }

}
