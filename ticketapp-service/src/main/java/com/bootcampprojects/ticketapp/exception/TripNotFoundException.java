package com.bootcampprojects.ticketapp.exception;

public class TripNotFoundException extends RuntimeException{
    public TripNotFoundException(String message) {
        super(message);
    }
}