package com.atguigu.springcloud.service;

import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService{
    @GetMapping("/payment/{id}")
    Result<Payment> findById(@PathVariable("id") Long id);
}
