package com.novli.order.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SenderController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/send/computer")
    public void sendComputerMessage() {
        amqpTemplate.convertAndSend("orderExchange","fruit","now:" + new Date());
    }
    @GetMapping("/send/fruit")
    public void sendFruitMessage() {
        amqpTemplate.convertAndSend("orderExchange","computer", "now:" + new Date());
    }
}
