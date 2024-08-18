package com.afroane.inventory_service.dto;

public record InventoryRequest(String id, String skuCode, Integer quantity) {
}
