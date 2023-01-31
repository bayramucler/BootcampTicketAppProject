package com.bootcampprojects.ticketapp.controller;

import com.bootcampprojects.ticketapp.client.PaymentStatusType;
import com.bootcampprojects.ticketapp.model.Order;
import com.bootcampprojects.ticketapp.model.User;
import com.bootcampprojects.ticketapp.request.OrderRequest;
import com.bootcampprojects.ticketapp.request.UserRequest;
import com.bootcampprojects.ticketapp.response.UserResponse;
import com.bootcampprojects.ticketapp.service.OrderService;
import com.bootcampprojects.ticketapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderRequest orderRequest) {
        orderService.create(orderRequest);
        return ResponseEntity.ok("Sipariş oluşturuldu");
    }


    @PutMapping("/{orderId}/paymentstatus")
    public ResponseEntity<String> updatePaymentStatusType(@PathVariable int orderId, @RequestBody PaymentStatusType paymentStatusType) {
        Order order = orderService.updatePaymentStatusType(orderId, paymentStatusType);
        return ResponseEntity.ok("PaymentStatus başarılı şekilde güncellendi.");
    }
}
