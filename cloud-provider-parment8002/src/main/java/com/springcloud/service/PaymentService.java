package com.springcloud.service;


import com.springcloud.entity.Payment;

public interface PaymentService {
    public int addPayment(Payment paymentnt);

    public Payment getPaymentById(Long id);
}
