package com.example.service.payment;

import com.example.domain.payment.Payment;
import org.springframework.data.domain.Page;

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

    /**
     * @param payment
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<Payment> queryPageByConditions(Payment payment, int pageNumber, int pageSize);
}
