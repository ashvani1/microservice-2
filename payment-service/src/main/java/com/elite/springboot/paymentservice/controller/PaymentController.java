package com.elite.springboot.paymentservice.controller;

import com.elite.springboot.paymentservice.model.PaymentRequest;
import com.elite.springboot.paymentservice.model.PaymentResponse;
import com.elite.springboot.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Log4j2
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
        return new ResponseEntity<>(
                paymentService.doPayment(paymentRequest),
                HttpStatus.CREATED);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentDetails(@PathVariable long orderId) {
        log.info("PaymentController :: getPaymentDetails()");
        return new ResponseEntity<>(
                paymentService.getPaymentDetailByOrderId(orderId), HttpStatus.OK
        );
    }

}
