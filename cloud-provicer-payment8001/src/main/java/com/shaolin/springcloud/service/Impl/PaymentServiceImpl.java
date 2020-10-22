package com.shaolin.springcloud.service.Impl;

import com.shaolin.springcloud.dao.PaymentMapper;
import com.shaolin.springcloud.entity.Payment;
import com.shaolin.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {


    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
