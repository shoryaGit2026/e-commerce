package com.emart.inventory_module.consumer;

import org.springframework.kafka.annotation.KafkaListener;

public class InventoryEventConsumer {


    @KafkaListener(

           topics="orderEvent", groupId="inventory"

    )
    public void orderEventConsumer()
    {

    }
}
