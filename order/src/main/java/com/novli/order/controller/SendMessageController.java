package com.novli.order.controller;

import com.novli.order.dto.OrderDto;
import com.novli.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process() {

        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId("123321");
        streamClient.output().send(MessageBuilder.withPayload(orderDto).build());
    }


}
