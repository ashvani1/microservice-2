package com.elite.springboot.productservice.service;

import com.elite.springboot.productservice.entity.Product;
import com.elite.springboot.productservice.exception.ProductServiceCustomException;
import com.elite.springboot.productservice.model.ProductRequest;
import com.elite.springboot.productservice.model.ProductResponse;
import com.elite.springboot.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("adding product with name: {}", productRequest.getName());

        Product product = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND"));


        //we have 2 options to create ProductResponse. We can use Builder pattern or BeanUtils

        ProductResponse productResponse = new ProductResponse();
        //There should be same properties in Product and ProductResponse, then only below will work
        copyProperties(product, productResponse);

        //Builder Pattern
        /*ProductResponse productResponse = ProductResponse.builder().productName(product.getProductName())
                .productPrice(product.getPrice())
                .productQuantity(product.getQuantity())
                .productId(product.getProductId()).build();*/
        return productResponse;
    }
}
