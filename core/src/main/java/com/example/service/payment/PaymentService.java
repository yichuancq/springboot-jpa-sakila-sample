package com.example.service.payment;

import com.example.domain.payment.Payment;

import java.util.List;

/**
 * @author yichuan
 */
public interface PaymentService {

    /**
     * 多条件查询
     *
     * @param payment
     * @return
     */
    List<Payment> queryByConditions(Payment payment);

}
