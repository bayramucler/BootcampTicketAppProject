package com.bootcampprojects.ticketapp.response;

import com.bootcampprojects.ticketapp.model.enums.TripStatusType;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;

import java.time.LocalDateTime;

public class TripResponse {
    private Integer id;
    private String fromProvince;
    private String toProvince;
    private LocalDateTime createDate;
    private TripStatusType status;
    private VehicleType vehicleType;
    private short vehicleCapacity;
    private short seatCount;
    private double price;
    private LocalDateTime dateTime;

    public TripResponse() {
    }

    public TripResponse(Integer id, String fromProvince, String toProvince, LocalDateTime createDate, TripStatusType status, VehicleType vehicleType, short vehicleCapacity, short seatCount, double price) {
        this.id = id;
        this.fromProvince = fromProvince;
        this.toProvince = toProvince;
        this.createDate = createDate;
        this.status = status;
        this.vehicleType = vehicleType;
        this.vehicleCapacity = vehicleCapacity;
        this.seatCount = seatCount;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
