package com.example.service.inventory;

import com.example.domain.inventory.Inventory;

public interface InventoryService {

    Inventory findOneById(Integer inventoryId);
}
