package com.liton.rabbitmqfirstexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Md. Liton Miah
 * @Date 7/6/2021
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderStatus {
    private Order order;
    private String status; //progress, completed
    private String message;
}
