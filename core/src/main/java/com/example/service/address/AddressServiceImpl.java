package com.example.service.address;

import com.example.domain.address.Address;
import com.example.repostiory.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepostiory;

    @Override
    public Address findOneById(Integer addressId) {
        Optional<Address> actor = addressRepostiory.findById(addressId);
        if (actor.isPresent()) {
            return actor.get();
        }
        return null;
    }
}
