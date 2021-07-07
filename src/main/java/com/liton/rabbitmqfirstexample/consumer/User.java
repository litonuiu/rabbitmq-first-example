package com.liton.rabbitmqfirstexample.consumer;

import com.liton.rabbitmqfirstexample.config.MessagingConfig;
import com.liton.rabbitmqfirstexample.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Md. Liton Miah
 * @Date 7/6/2021
 */

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received from queue " + orderStatus);
    }
}
