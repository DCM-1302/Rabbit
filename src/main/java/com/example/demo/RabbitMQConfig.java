package com.example.demo;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "product.stock.low";
    public static final String QUEUE_NAME = "example_queue";
    public static final String ROUTING_KEY = "example_routing_key";

    @Bean
    public Queue stockLowQueue() {
        return new Queue("product.stock.low", true);
    }

    @Bean
    public TopicExchange stockLowExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue stockLowQueue, TopicExchange stockLowExchange) {
        return BindingBuilder.bind(stockLowQueue).to(stockLowExchange).with("#");
    }
}

