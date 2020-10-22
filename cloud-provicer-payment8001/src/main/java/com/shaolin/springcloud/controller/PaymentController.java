package com.shaolin.springcloud.controller;

import com.shaolin.springcloud.entity.CommonResult;
import com.shaolin.springcloud.entity.Payment;
import com.shaolin.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/add")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        return new CommonResult(200,"ok",result);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment paymentById = paymentService.getPaymentById(id);
        return new CommonResult(200,"ok",paymentById);
    }
}
