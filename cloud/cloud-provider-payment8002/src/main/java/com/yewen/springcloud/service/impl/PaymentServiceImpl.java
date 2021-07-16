package com.yewen.springcloud.service.impl;

import com.yewen.springcloud.dao.PaymentDao;
import com.yewen.springcloud.entities.Payment;
import com.yewen.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ShadowStart
 * @create 2021-07-02 20:31
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao PaymentDao;

    @Override
    public int create(Payment payment) {
        return PaymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return PaymentDao.getPaymentById(id);
    }
}
