package com.bootcampprojects.ticketapp.exception;

public class AvailableSeatNotFoundException extends RuntimeException{
    public AvailableSeatNotFoundException(String message) {
        super(message);
    }
}