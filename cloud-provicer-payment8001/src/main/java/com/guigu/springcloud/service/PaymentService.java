package com.guigu.springcloud.service;

import com.guigu.springcloud.entity.Payment;

public interface PaymentService {


    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
