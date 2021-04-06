package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfoOk(Long id){
        return "ThreadPool" + Thread.currentThread().getName() + "paymentInfoOk " + id ;
    }

    public String paymentInfoTimeOut(Long id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ThreadPool" + Thread.currentThread().getName() + "paymentInfoTimeOut " + id;
    }
}
