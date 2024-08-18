package com.afromane.product_service.controller;

import com.afromane.product_service.dto.ProductDTO;
import com.afromane.product_service.dto.ProductRequest;
import com.afromane.product_service.exception.message.ResponseMessage;
import com.afromane.product_service.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;
    @PostMapping()
    public ResponseEntity<ResponseMessage> createProduct(@RequestBody ProductRequest productRequest){
        ResponseMessage responseMessage = ResponseMessage.builder()
                            .message("Item created successfully")
                            .code(200)
                            .build();
        productService.createProduct(productRequest);
        return new ResponseEntity<>(responseMessage,HttpStatus.CREATED);


    }
    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        return new ResponseEntity<>( this.productService.getAllProduct()
                .stream()
                .map(product -> modelMapper.map(product,ProductDTO.class))
                .collect(Collectors.toList()),HttpStatus.OK );

    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable String id){
        return new ResponseEntity<>(
                modelMapper.map(this.productService.getProductById(id),ProductDTO.class),
                HttpStatus.OK);

    }
}
