package com.afroane.inventory_service.service;


import com.afroane.inventory_service.dto.InventoryRequest;

public interface InventoryService {
   public void createInventory(InventoryRequest inventoryRequest);
    public Boolean isInStock (String skuCode, Integer quantity);

}
