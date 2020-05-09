package com.example.repostiory;

import com.example.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author yichuan
 * 支付
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer>,
        JpaSpecificationExecutor<Payment> {
}
