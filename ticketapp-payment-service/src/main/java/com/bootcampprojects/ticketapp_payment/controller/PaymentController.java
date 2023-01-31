package com.bootcampprojects.ticketapp_payment.controller;


import com.bootcampprojects.ticketapp_payment.model.Payment;
import com.bootcampprojects.ticketapp_payment.request.PaymentRequest;
import com.bootcampprojects.ticketapp_payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> getAll() {
        return ResponseEntity.ok(paymentService.getAll());
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody PaymentRequest paymentRequest) {
        Payment payment = paymentService.create(paymentRequest);
        return ResponseEntity.ok(payment);
    }

}
