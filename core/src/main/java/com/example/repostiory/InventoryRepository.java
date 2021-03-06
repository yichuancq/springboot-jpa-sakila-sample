package com.example.repostiory;

import com.example.domain.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 库存
 *
 * @author yichuan
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer>,
        JpaSpecificationExecutor<Inventory> {
}
