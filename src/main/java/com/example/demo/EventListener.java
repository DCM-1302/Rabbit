package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventListener {
    @RabbitListener(queues = "product.stock.low")
    public void listen(String producto) throws InterruptedException {
        log.info("Producto a punto de agotarse: "+ producto);
        Thread.sleep(100);
    }
}
