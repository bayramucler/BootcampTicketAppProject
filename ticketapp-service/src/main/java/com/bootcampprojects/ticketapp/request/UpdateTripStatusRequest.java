package com.bootcampprojects.ticketapp.request;

import com.bootcampprojects.ticketapp.model.enums.TripStatusType;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;

public class UpdateTripStatusRequest {
    private Integer tripId;
    private TripStatusType status;
    private Integer userId;

    public UpdateTripStatusRequest() {
    }

    public UpdateTripStatusRequest(Integer tripId, TripStatusType status, Integer userId) {
        this.tripId = tripId;
        this.status = status;
        this.userId = userId;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public TripStatusType getStatus() {
        return status;
    }

    public void setStatus(TripStatusType status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
