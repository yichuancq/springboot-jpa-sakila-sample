package com.example.repostiory;

import com.example.domain.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
