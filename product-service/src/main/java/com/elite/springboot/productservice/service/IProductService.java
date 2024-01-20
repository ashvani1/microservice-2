package com.elite.springboot.productservice.service;

import com.elite.springboot.productservice.model.ProductRequest;
import com.elite.springboot.productservice.model.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long id);
}
