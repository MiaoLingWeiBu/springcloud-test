package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/save")
    public CommonResult addPayment(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        if(result>0){
            return new CommonResult(200,"添加成功"+serverPort,result);
        }
        return new CommonResult(444,"添加失败");
    }

    @GetMapping("/show/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment paymentById = paymentService.getPaymentById(id);
        if(paymentById!=null){
            log.info("successs");
            return new CommonResult(200,"查询成功"+serverPort,paymentById);
        }
        return new CommonResult(444,"查询失败");
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
