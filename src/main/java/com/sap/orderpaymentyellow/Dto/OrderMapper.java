package com.sap.orderpaymentyellow.Dto;

import com.sap.orderpaymentyellow.model.AuditData;
import com.sap.orderpaymentyellow.model.OrderPayment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "orderId", source = "orderId")
    @Mapping(target = "amount", source = "paymentAmount")
    @Mapping(target = "orderStatusId", source = "orderStatusId")
    @Mapping(target = "creditCardNumber", source = "creditCardNumber")
    @Mapping(target = "expiryOn", source = "expiryOn")
    @Mapping(target = "userId", source = "customerId")
    @Mapping(target = "paymentType", source = "paymentType")
    @Mapping(target = "cvc", source = "cvc")

    OrderPayment OrderDTOToOrderPayment (OrderDTO order);

}


