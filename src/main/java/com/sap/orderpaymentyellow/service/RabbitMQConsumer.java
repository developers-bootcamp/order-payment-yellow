package com.sap.orderpaymentyellow.service;

import com.sap.orderpaymentyellow.Dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class RabbitMQConsumer {
    private static  final Logger LOGGER= LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiveMessage(byte[] messageBytes) {
        try {
            String messageJson = new String(messageBytes);
            LOGGER.info(String.format("message received: -> %s",messageJson));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }



