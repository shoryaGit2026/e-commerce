package com.ecom.payment_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @GetMapping("/do")
    public ResponseEntity<String> doPayment() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Payment accepted>>>>>>Testing");
    }
}
