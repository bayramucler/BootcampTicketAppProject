package com.bootcampprojects.ticketapp.exception;

public class CorpareteTicketLimitException extends RuntimeException{
    public CorpareteTicketLimitException(String message) {
        super(message);
    }
}