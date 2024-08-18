package com.afromane.order_service.dto;

import java.math.BigDecimal;

public record OrderRequest( String id,
         String skuCode,
         BigDecimal price,
         Integer quantity) {
}
