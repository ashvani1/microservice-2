package com.elite.springboot.orderservice.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private long productId;
    private long totalAmount;
    private long quantity;
    private PaymentMode paymentMode;
}
