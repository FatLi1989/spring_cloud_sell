package com.novli.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.novli.order.entity.Info;
import com.novli.order.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProductInfoReceiver {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        //message => productInput
        List<Info> infoList = JsonUtil.fromJson(message, new TypeReference <List<Info>> () {});
        log.info("从队列【{}】中接收到消息 {}", "productInfo", infoList);
        //储存到redis中
        for (Info info : infoList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, info.getProductId()),
                    String.valueOf(info.getProductStock()));
        }
    }
}
