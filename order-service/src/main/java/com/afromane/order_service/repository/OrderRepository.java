package com.afromane.order_service.repository;

import com.afromane.order_service.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}
