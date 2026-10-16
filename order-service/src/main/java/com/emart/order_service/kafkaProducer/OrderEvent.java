package com.emart.order_service.kafkaProducer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class OrderEvent {

    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double price;
    private LocalDateTime orderDateTime;
    private String status;

}
