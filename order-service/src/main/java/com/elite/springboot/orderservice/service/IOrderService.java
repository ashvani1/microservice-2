package com.elite.springboot.orderservice.service;

import com.elite.springboot.orderservice.model.OrderRequest;

public interface IOrderService {
    long placeOrder(OrderRequest orderRequest);
}
