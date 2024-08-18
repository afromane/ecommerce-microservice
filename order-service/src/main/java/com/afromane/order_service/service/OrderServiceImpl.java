package com.afromane.order_service.service;

import com.afromane.order_service.dto.OrderRequest;
import com.afromane.order_service.entity.Order;
import com.afromane.order_service.exception.EntityNotFoundException;
import com.afromane.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public  void placeOrder(OrderRequest orderRequest){
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .price(orderRequest.price())
                .skuCode(orderRequest.skuCode())
                .quantity(orderRequest.quantity())
                .build();

        orderRepository.save(order);
        log.info("Order placed successfully");
        
    }

    public List<Order> getAllOrder() {
        Optional<List<Order>>  orders = Optional.of(orderRepository.findAll());
        return orders.orElseThrow(()->new EntityNotFoundException("Not Found"));
    }

    public Order getOrderById(String id) {
        Optional<Order> order = this.orderRepository.findById(id);
        return order.orElseThrow(()->new EntityNotFoundException("Not Found"));
    }
}
