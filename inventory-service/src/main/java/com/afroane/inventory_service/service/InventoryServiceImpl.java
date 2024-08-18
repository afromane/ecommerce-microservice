package com.afroane.inventory_service.service;

import com.afroane.inventory_service.dto.InventoryRequest;
import com.afroane.inventory_service.entity.Inventory;
import com.afroane.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public Boolean isInStock(String skuCode, Integer quantity) {
        // find an inventory for a given skuCode where quantity >0
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }

    public  void createInventory(InventoryRequest inventoryRequest){
        Inventory inventory = Inventory.builder()
                .skuCode(inventoryRequest.skuCode())
                .quantity(inventoryRequest.quantity())
                .build();

        inventoryRepository.save(inventory);
        log.info("Inventory created successfully");
        
    }


}
