package com.elite.springboot.paymentservice.service;

import com.elite.springboot.paymentservice.model.PaymentRequest;

public interface IPaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
