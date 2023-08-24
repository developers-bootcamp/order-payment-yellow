package com.sap.orderpaymentyellow;

import com.sap.orderpaymentyellow.Dto.OrderDTO;
import com.sap.orderpaymentyellow.Dto.OrderMapper;
import com.sap.orderpaymentyellow.service.PaymentProcessingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderPaymentYellowApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderPaymentYellowApplication.class, args);
		/*OrderDTO o= new OrderDTO("hjk","hlh",12, OrderDTO.status.charging,255828852L,"12/25","123", OrderDTO.PaymentType.CREDIT);
		String requestBody = OrderMapper.INSTANCE.orderToOrderDTO(o).toString();*/
		PaymentProcessingService paymentProcessingService= new PaymentProcessingService();
		paymentProcessingService.PaymentProcessing();

	}

}
