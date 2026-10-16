package com.emart.product_module.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.product_module.Service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{productId}/{quantity}")
    public ResponseEntity<String> getProducts(@PathVariable Long productId, @PathVariable Integer quantity) {
        Long available = productService.checkStockAvailability(productId, quantity);
        return ResponseEntity.ok(available.toString());
    }


}
