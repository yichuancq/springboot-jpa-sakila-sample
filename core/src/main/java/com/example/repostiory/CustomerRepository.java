package com.example.repostiory;

import com.example.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
