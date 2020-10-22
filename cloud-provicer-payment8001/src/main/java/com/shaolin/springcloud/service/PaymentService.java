package com.shaolin.springcloud.service;

import com.shaolin.springcloud.entity.Payment;

public interface PaymentService {


    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
