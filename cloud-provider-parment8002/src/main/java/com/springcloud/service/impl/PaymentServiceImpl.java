package com.springcloud.service.impl;

import com.springcloud.entity.Payment;
import com.springcloud.mapper.PaymentMapper;
import com.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int addPayment(Payment paymentnt) {
        return paymentMapper.addPayment(paymentnt);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
