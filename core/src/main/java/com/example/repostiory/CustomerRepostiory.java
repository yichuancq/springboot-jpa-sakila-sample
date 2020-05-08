package com.example.repostiory;

import com.example.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepostiory extends JpaRepository<Customer, Integer> {
}
