package com.example.repostiory;

import com.example.domain.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface StoreRepository extends JpaRepository<Store, Integer> {
}
