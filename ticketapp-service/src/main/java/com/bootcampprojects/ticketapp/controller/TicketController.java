package com.bootcampprojects.ticketapp.controller;

import com.bootcampprojects.ticketapp.model.Ticket;
import com.bootcampprojects.ticketapp.repository.TicketInfoProjection;
import com.bootcampprojects.ticketapp.repository.TotalAmountTripInfoProjection;
import com.bootcampprojects.ticketapp.request.TicketRequest;
import com.bootcampprojects.ticketapp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("");
    }

    @GetMapping(value="/user/{userId}")
    public ResponseEntity<List<TicketInfoProjection>> getTicketInfoByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(ticketService.getTicketInfoByUserId(userId));
    }

}
