package com.example.repostiory;

import com.example.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepostiory extends JpaRepository<Address,Integer> {
}
