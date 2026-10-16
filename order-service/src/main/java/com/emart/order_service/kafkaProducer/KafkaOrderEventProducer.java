package com.emart.order_service.kafkaProducer;

import org.springframework.kafka.core.KafkaTemplate;

public class KafkaOrderEventProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public KafkaOrderEventProducer(KafkaTemplate<String,OrderEvent> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }

    public void publishOrder(OrderEvent event)
    {
        kafkaTemplate.send("order-event",event.getProductId().toString(),event);
    }

}
