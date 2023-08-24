package com.sap.orderpaymentyellow.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@SuperBuilder(toBuilder = true)
public class OrderPayment {

    private String orderId;
    private String userId;
    private double amount;
    private int invoiceNumber;
    private PaymentType paymentType;
    private long creditCardNumber;
    private String expiryOn;
    private String cvc;
    private AuditData auditData;
    public enum PaymentType {CREDIT,DEBIT}
}
