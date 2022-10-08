package com.springcloud.mapper;

import com.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    int addPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
