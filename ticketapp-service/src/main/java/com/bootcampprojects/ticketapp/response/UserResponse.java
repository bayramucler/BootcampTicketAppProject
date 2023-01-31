package com.bootcampprojects.ticketapp.response;

import com.bootcampprojects.ticketapp.model.enums.UserType;

public class UserResponse {
    private Integer id;
    private String name;
    private String email;
    private UserType type;


    public UserResponse() {
    }

    public UserResponse(Integer id, String name, String email, UserType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
