package com.sap.orderpaymentyellow.consumer;

import com.sap.orderpaymentyellow.model.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
    private static  final Logger LOGGER= LoggerFactory.getLogger(RabbitMQConsumer.class);
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consumer(Try try1){
        LOGGER.info(String.format("message received: ",try1.toString()));
 }

}
