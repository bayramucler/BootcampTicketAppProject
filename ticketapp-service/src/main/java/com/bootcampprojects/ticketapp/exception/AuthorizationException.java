package com.bootcampprojects.ticketapp.exception;

public class AuthorizationException extends RuntimeException{
    public AuthorizationException(String message) {
        super(message);
    }
}