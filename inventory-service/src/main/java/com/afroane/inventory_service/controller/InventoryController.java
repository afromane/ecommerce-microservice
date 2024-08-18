package com.afroane.inventory_service.controller;

import com.afroane.inventory_service.dto.InventoryRequest;
import com.afroane.inventory_service.exception.message.ResponseMessage;
import com.afroane.inventory_service.service.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory/")
public class InventoryController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private  InventoryService inventoryService;
    @PostMapping()
    public ResponseEntity<ResponseMessage> createOrder(@RequestBody InventoryRequest inventoryRequest){
        ResponseMessage responseMessage = ResponseMessage.builder()
                .message("Item created successfully")
                .code(200)
                .build();
        inventoryService.createInventory(inventoryRequest);
        return new ResponseEntity<>(responseMessage,HttpStatus.CREATED);


    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity){
        return  inventoryService.isInStock(skuCode,quantity);
    }

}
