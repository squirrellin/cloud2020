package com.guigu.springcloud.dao;

import com.guigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {


    public  int create(Payment payment);

    public Payment getPaymentById(Long id);
}
