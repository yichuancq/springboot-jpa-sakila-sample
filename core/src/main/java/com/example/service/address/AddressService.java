package com.example.service.address;

import com.example.domain.address.Address;


public interface AddressService {

    Address findOneById(Integer addressId);
}
