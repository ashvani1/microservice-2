package com.elite.springboot.paymentservice.service;

import com.elite.springboot.paymentservice.entity.TransactionDetails;
import com.elite.springboot.paymentservice.model.PaymentMode;
import com.elite.springboot.paymentservice.model.PaymentRequest;
import com.elite.springboot.paymentservice.model.PaymentResponse;
import com.elite.springboot.paymentservice.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PaymentService implements IPaymentService{

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("PaymentService: doPayment() :: {}", paymentRequest);

        TransactionDetails transactionDetails =
                TransactionDetails.builder()
                        .paymentDate(Instant.now())
                        .paymentMode(paymentRequest.getPaymentMode().name())
                        .paymentStatus("SUCCESS")
                        .orderId(paymentRequest.getOrderId())
                        .referenceNumber(paymentRequest.getReferenceNumber())
                        .amount(paymentRequest.getAmount())
                        .build();
        transactionDetailsRepository.save(transactionDetails);
        log.info("Transaction completed with id : {}", transactionDetails.getId());
        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailByOrderId(long id) {
        log.info("fetching all payment details");
        List<TransactionDetails> transactionDetails1 = transactionDetailsRepository.findAll();
        for(TransactionDetails transactionDetail : transactionDetails1) {
            log.info("current payment detail {} ", transactionDetail);
        }
        log.info("fetching payment details with id {} ", id);
        //TransactionDetails transactionDetails = transactionDetailsRepository.findById(orderId).get();
        TransactionDetails transactionDetails = transactionDetailsRepository.findByOrderId(id);

        PaymentResponse paymentResponse = PaymentResponse.builder()
                .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                .paymentId(transactionDetails.getId())
                .paymentDate(transactionDetails.getPaymentDate())
                .orderId(transactionDetails.getOrderId())
                .status(transactionDetails.getPaymentStatus())
                .amount(transactionDetails.getAmount())
                .build();

        return paymentResponse;
    }
}
