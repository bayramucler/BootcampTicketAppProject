package com.bootcampprojects.ticketapp.controller;

import com.bootcampprojects.ticketapp.model.User;
import com.bootcampprojects.ticketapp.request.LoginRequest;
import com.bootcampprojects.ticketapp.request.UserRequest;
import com.bootcampprojects.ticketapp.response.UserResponse;
import com.bootcampprojects.ticketapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value ="/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.create(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }


}
