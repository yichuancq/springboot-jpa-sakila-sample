package com.example.service.customer;

import com.example.domain.customer.Customer;
import com.example.repostiory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepostiory;

    @Override
    public Customer findOneById(Integer customerId) {
        Optional<Customer> customer = customerRepostiory.findById(customerId);
        if (customer.isPresent()) {
            return customer.get();
        }
        return null;
    }
}
