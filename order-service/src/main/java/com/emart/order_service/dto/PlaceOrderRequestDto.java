package com.emart.order_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderRequestDto {
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double price;
    private LocalDateTime orderDateTime;
    private String status;
}
