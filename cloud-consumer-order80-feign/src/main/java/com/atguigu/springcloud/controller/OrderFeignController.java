package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.pojo.Payment;
import com.atguigu.springcloud.pojo.Result;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.findById(id);
    }

//    @GetMapping("consumer/payment/create")
//    public CommonResult<Integer> create(Payment payment) {
//        return paymentFeignService.add(payment);
//    }
//
//    @GetMapping("consumer/payment/feign/timeout")
//    public String paymentFeignTimeOut() {
//        return paymentFeignService.paymentFeignTimeOut();
//    }

}
