package com.bootcampprojects.ticketapp.response;

import com.bootcampprojects.ticketapp.model.enums.GenderType;

public class TicketResponse {
    private Integer id;
    private String passengerName;
    private GenderType passengerGenderType;
    private short seatNumber;
    private double price;
    private Integer tripId;
    private Integer userId;

    public TicketResponse() {
    }

    public TicketResponse(String passengerName, GenderType passengerGenderType, short seatNumber, double price, Integer tripId, Integer userId) {
        this.passengerName = passengerName;
        this.passengerGenderType = passengerGenderType;
        this.seatNumber = seatNumber;
        this.price = price;
        this.tripId = tripId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public GenderType getPassengerGenderType() {
        return passengerGenderType;
    }

    public void setPassengerGenderType(GenderType passengerGenderType) {
        this.passengerGenderType = passengerGenderType;
    }

    public short getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(short seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
