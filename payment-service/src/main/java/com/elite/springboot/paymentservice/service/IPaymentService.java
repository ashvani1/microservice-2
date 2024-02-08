package com.elite.springboot.paymentservice.service;

import com.elite.springboot.paymentservice.model.PaymentRequest;
import com.elite.springboot.paymentservice.model.PaymentResponse;

public interface IPaymentService {
    Long doPayment(PaymentRequest paymentRequest);
    PaymentResponse getPaymentDetailByOrderId(long orderId);
}
