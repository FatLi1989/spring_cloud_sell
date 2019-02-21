package com.novli.order.message;

import com.novli.order.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

  /*  @StreamListener(StreamClient.INPUT)
    public void process (OrderDto dto) {
        log.info("StreamReceiver: {}", dto);
    }*/

}
