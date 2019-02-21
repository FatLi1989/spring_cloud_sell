package com.novli.order.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
public class EvnController {

    @Value("${env}")
    private String evn;

    @GetMapping("/print")
    public String print() {
        log.info("The Evn is = {}", evn );
        return evn;
    }


}
