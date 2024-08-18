package com.afromane.product_service.service;

import com.afromane.product_service.dto.ProductDTO;
import com.afromane.product_service.dto.ProductRequest;
import com.afromane.product_service.entity.Product;
import com.afromane.product_service.exception.EntityNotFoundException;
import com.afromane.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements  ProductService {

    private final ProductRepository productRepository;

    public  void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product created successfully");
        
    }

    public List<Product> getAllProduct() {
        Optional<List<Product>>  products = Optional.of(productRepository.findAll());
        return products.orElseThrow(()->new EntityNotFoundException("Not Found"));
    }

    public Product getProductById(String id) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.orElseThrow(()->new EntityNotFoundException("Not Found"));
    }
}
