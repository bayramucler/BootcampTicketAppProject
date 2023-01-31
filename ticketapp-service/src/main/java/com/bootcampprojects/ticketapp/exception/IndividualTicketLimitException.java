package com.bootcampprojects.ticketapp.exception;

public class IndividualTicketLimitException extends RuntimeException{
    public IndividualTicketLimitException(String message) {
        super(message);
    }
}