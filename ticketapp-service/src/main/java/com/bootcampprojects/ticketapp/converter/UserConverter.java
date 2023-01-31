package com.bootcampprojects.ticketapp.converter;

import com.bootcampprojects.ticketapp.model.User;
import com.bootcampprojects.ticketapp.request.UserRequest;
import com.bootcampprojects.ticketapp.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    public UserResponse convert(User user) {
        UserResponse response = new UserResponse();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setName(user.getName());
        response.setType(user.getType());
        return response;
    }

    public User convert(UserRequest userRequest, String hash) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setPassword(hash);
        user.setCreateDate(LocalDateTime.now());
        user.setType(userRequest.getType());
        return user;
    }

    public List<UserResponse> convert(List<User> userList) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : userList) {
            userResponses.add(convert(user));
        }
        return userList.stream().map(this::convert).toList();
    }
}
