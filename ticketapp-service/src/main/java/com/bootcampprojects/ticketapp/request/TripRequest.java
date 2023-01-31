package com.bootcampprojects.ticketapp.request;

import com.bootcampprojects.ticketapp.model.Ticket;
import com.bootcampprojects.ticketapp.model.User;
import com.bootcampprojects.ticketapp.model.enums.TripStatusType;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class TripRequest {
    private String fromProvince;
    private String toProvince;
    private TripStatusType status;
    private VehicleType vehicleType;
    private short vehicleCapacity;
    private short seatCount;
    private double price;
    private LocalDateTime dateTime;
    private Integer userId;


    public TripRequest() {
    }

    public TripRequest(String fromProvince, String toProvince, TripStatusType status, VehicleType vehicleType, short vehicleCapacity, short seatCount, double price, Integer userId) {
        this.fromProvince = fromProvince;
        this.toProvince = toProvince;
        this.status = status;
        this.vehicleType = vehicleType;
        this.vehicleCapacity = vehicleCapacity;
        this.seatCount = seatCount;
        this.price = price;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(String fromProvince) {
        this.fromProvince = fromProvince;
    }

    public String getToProvince() {
        return toProvince;
    }

    public void setToProvince(String toProvince) {
        this.toProvince = toProvince;
    }

    public TripStatusType getStatus() {
        return status;
    }

    public void setStatus(TripStatusType status) {
        this.status = status;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public short getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(short vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public short getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(short seatCount) {
        this.seatCount = seatCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
