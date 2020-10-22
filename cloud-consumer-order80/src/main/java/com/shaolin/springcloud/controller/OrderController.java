package com.shaolin.springcloud.controller;

import com.shaolin.springcloud.dal.biz.UserServiceBiz;
import com.shaolin.springcloud.entity.CommonResult;
import com.shaolin.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    private static final String PARAM_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserServiceBiz userServiceBiz;

    @GetMapping("/consumer/payment/add")
    public CommonResult add(Payment payment){

        return restTemplate.postForObject(PARAM_URL +"/payment/add",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        return restTemplate.getForObject(PARAM_URL +"/payment/get/"+ id,CommonResult.class);
    }
}
