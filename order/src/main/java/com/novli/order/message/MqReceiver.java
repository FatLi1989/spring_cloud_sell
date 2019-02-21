package com.novli.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("orderExchange"),
            key = "fruit",
            value = @Queue("fruitQueue")
    ))
    public void processFruit(String message) {
        log.info("fruitMq ={}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("orderExchange"),
            key = "computer",
            value = @Queue("computerQueue")
    ))
    public void processComputer(String message) {
        log.info("computerMq ={}", message);
    }
}
