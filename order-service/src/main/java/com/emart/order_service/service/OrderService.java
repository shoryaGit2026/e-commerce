package com.emart.order_service.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.emart.order_service.kafkaProducer.KafkaOrderEventProducer;
import com.emart.order_service.kafkaProducer.OrderEvent;
import org.springframework.stereotype.Service;

import com.emart.order_service.FeignClientsConfig.ProductFeignClient;
import com.emart.order_service.OrderEntity;
import com.emart.order_service.dto.PlaceOrderRequestDto;
import com.emart.order_service.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductFeignClient productFeignClient;
    private final KafkaOrderEventProducer orderEventProducer;

    public OrderService(ProductFeignClient productFeignClient, OrderRepository orderRepository,KafkaOrderEventProducer orderEventProducer) {
        this.productFeignClient = productFeignClient;
        this.orderRepository = orderRepository;
        this.orderEventProducer=orderEventProducer;

    }

    public String placeOrder(PlaceOrderRequestDto orderRequest) {
       /*  if (orderRequest == null
                || orderRequest.getProductId() == null
                || orderRequest.getProductId() <= 0
                || orderRequest.getQuantity() == null
                || orderRequest.getQuantity() <= 0) {
            throw new IllegalArgumentException("Product ID and quantity must be positive");
        }

        Long availableProductId = productFeignClient.isStockAvailable(
                orderRequest.getProductId(), orderRequest.getQuantity());
        if (availableProductId == null || availableProductId <= 0) {
            return "Product is not available in the requested quantity";
        }*/
        OrderEntity order = new OrderEntity().builder().productId(orderRequest.getProductId())
        .price(orderRequest.getPrice())
        .quantity(orderRequest.getQuantity())
        .status(orderRequest.getStatus())
        .orderDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS))
        .build();

        OrderEvent order = new OrderEvent().productId(orderRequest.getProductId()).price(orderRequest.getPrice())
                .quantity(orderRequest.getQuantity())
                .status(orderRequest.getStatus())
                .orderDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS)).build();

        orderEventProducer.publishOrder(order);

      orderRepository.save(order);

        return "Order placed successfully";
    }

    
}
