package com.shaolin.springcloud.dao;

import com.shaolin.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {


    public  int create(Payment payment);

    public Payment getPaymentById(Long id);
}
