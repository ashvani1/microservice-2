package com.elite.springboot.orderservice.service;

import com.elite.springboot.orderservice.model.OrderRequest;
import com.elite.springboot.orderservice.model.OrderResponse;

public interface IOrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
