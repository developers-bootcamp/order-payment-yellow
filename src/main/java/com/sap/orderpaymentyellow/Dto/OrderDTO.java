package com.sap.orderpaymentyellow.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String orderId ;
    private String customerId ;
    private double paymentAmount;
    private status orderStatusId;
    private long creditCardNumber;
    private String expiryOn;
    private String cvc;

    private PaymentType paymentType;


    public enum PaymentType {
        CREDIT,
        DEBIT
    }

//    public String toJson() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//
//        try {
//            return objectMapper.writeValueAsString(this);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
public enum status {New, cancelled, approved, charging, packing, delivered}
}
