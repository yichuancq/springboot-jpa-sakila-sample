package com.example.repostiory;

import com.example.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
