package com.afromane.order_service.controller;

import com.afromane.order_service.dto.OrderDTO;
import com.afromane.order_service.dto.OrderRequest;
import com.afromane.order_service.exception.message.ResponseMessage;
import com.afromane.order_service.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order/")
public class OrderController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderService orderService;
    @PostMapping()
    public ResponseEntity<ResponseMessage> createOrder(@RequestBody OrderRequest orderRequest){
        ResponseMessage responseMessage = ResponseMessage.builder()
                            .message("Item created successfully")
                            .code(200)
                            .build();
        orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(responseMessage,HttpStatus.CREATED);


    }
    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getAllOrder(){
        return new ResponseEntity<>( this.orderService.getAllOrder()
                .stream()
                .map(order -> modelMapper.map(order,OrderDTO.class))
                .collect(Collectors.toList()),HttpStatus.OK );

    }
    @GetMapping("{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable String id){
        return new ResponseEntity<>(
                modelMapper.map(this.orderService.getOrderById(id),OrderDTO.class),
                HttpStatus.OK);

    }
}
