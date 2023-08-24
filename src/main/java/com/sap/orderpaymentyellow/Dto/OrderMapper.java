package com.sap.orderpaymentyellow.Dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "paymentAmount", source = "totalAmount")
    @Mapping(target = "orderStatusId", source = "orderStatusId")
    @Mapping(target = "creditCardNumber", source = "creditCardNumber")
    @Mapping(target = "expiryOn", source = "expiryOn")
    @Mapping(target = "cvc", source = "cvc")
    SendPaymentDTO orderToOrderDTO(OrderDTO order);
}


