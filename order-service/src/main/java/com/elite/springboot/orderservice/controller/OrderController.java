package com.elite.springboot.orderservice.controller;

import com.elite.springboot.orderservice.model.OrderRequest;
import com.elite.springboot.orderservice.service.IOrderService;
import com.elite.springboot.orderservice.service.OrderService;
import jakarta.inject.Inject;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Data
@Log4j2
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
        log.info("received a request to create order with details : {}", orderRequest);
        long orderId = orderService.placeOrder(orderRequest);
        log.info("order created successfully with order Id: {} ", orderId);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }
}
