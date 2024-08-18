package com.afromane.order_service.service;

import com.afromane.order_service.dto.OrderRequest;
import com.afromane.order_service.entity.Order;

import java.util.List;

public interface OrderService {
    public  void placeOrder(OrderRequest orderRequest);
    public List<Order> getAllOrder();
    public Order getOrderById(String id);

}
