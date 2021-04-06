package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "PaymentController")
@RestController
@RequestMapping("/payment")
@CrossOrigin
public class PaymentController {
    @Resource
    private PaymentService paymentService;

//    @Value("${server.port}")
//    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Long id) {
        return paymentService.paymentInfoOk(id);
    }

    @GetMapping("/hystrix/ok_timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Long id) {
        return paymentService.paymentInfoTimeOut(id);
    }
}
