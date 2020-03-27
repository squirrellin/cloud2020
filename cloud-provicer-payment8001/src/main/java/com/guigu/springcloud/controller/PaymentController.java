package com.guigu.springcloud.controller;

import com.guigu.springcloud.entity.CommonResult;
import com.guigu.springcloud.entity.Payment;
import com.guigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/add")
    public CommonResult create(Payment payment){

        int result = paymentService.create(payment);
        return new CommonResult(200,"ok",result);
    }

    @GetMapping("/getPaymentById")
    public CommonResult getPaymentById(Long id){

        Payment paymentById = paymentService.getPaymentById(id);
        return new CommonResult(200,"ok",paymentById);
    }
}
