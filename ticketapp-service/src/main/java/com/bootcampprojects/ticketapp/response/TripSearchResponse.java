package com.bootcampprojects.ticketapp.response;

import com.bootcampprojects.ticketapp.model.enums.TripStatusType;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;

import java.time.LocalDateTime;

public class TripSearchResponse {
    private String fromProvince;
    private String toProvince;
    private LocalDateTime createDate;
    private TripStatusType status;
    private VehicleType vehicleType;
    private short seatCount;
    private double price;
    private LocalDateTime dateTime;

    public TripSearchResponse() {
    }

    public TripSearchResponse(Integer id, String fromProvince, String toProvince, LocalDateTime createDate, TripStatusType status, VehicleType vehicleType, short vehicleCapacity, short seatCount, double price, double totalAmount) {
        this.fromProvince = fromProvince;
        this.toProvince = toProvince;
        this.createDate = createDate;
        this.status = status;
        this.vehicleType = vehicleType;
        this.seatCount = seatCount;
        this.price = price;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
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
