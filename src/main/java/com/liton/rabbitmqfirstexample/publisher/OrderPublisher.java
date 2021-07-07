package com.liton.rabbitmqfirstexample.publisher;

import com.liton.rabbitmqfirstexample.config.MessagingConfig;
import com.liton.rabbitmqfirstexample.dto.Order;
import com.liton.rabbitmqfirstexample.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author Md. Liton Miah
 * @Date 7/6/2021
 */

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());
//        restaurantService
//        paymentService
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Order placed successfully in "
                + restaurantName);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);

        return "Success !!";
    }
}
