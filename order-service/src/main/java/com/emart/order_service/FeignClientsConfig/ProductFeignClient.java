package com.emart.order_service.FeignClientsConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-module")
public interface ProductFeignClient {

    @GetMapping("/api/v1/products/{productId}/{quantity}")
    Long isStockAvailable(@PathVariable("productId") Long productId,
                          @PathVariable("quantity") Integer quantity);

}
