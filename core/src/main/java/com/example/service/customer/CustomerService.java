package com.example.service.customer;

import com.example.domain.customer.Customer;

public interface CustomerService {

    Customer findOneById(Integer customerId);
}
