package com.afromane.product_service.service;

import com.afromane.product_service.dto.ProductRequest;
import com.afromane.product_service.entity.Product;

import java.util.List;

public interface ProductService{
    public  void createProduct(ProductRequest productRequest);
    public List<Product> getAllProduct();
    public Product getProductById(String id);

}
