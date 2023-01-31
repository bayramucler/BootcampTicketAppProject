package com.bootcampprojects.ticketapp.converter;

import com.bootcampprojects.ticketapp.model.Ticket;
import com.bootcampprojects.ticketapp.model.Trip;
import com.bootcampprojects.ticketapp.model.User;
import com.bootcampprojects.ticketapp.request.TicketRequest;
import com.bootcampprojects.ticketapp.request.TripRequest;
import com.bootcampprojects.ticketapp.request.UserRequest;
import com.bootcampprojects.ticketapp.response.TripResponse;
import com.bootcampprojects.ticketapp.response.TripSearchResponse;
import com.bootcampprojects.ticketapp.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TripConverter {
    public TripResponse convert(Trip trip) {
        TripResponse response = new TripResponse();
        response.setId(trip.getId());
        response.setFromProvince(trip.getFromProvince());
        response.setToProvince(trip.getToProvince());
        response.setPrice(trip.getPrice());
        response.setStatus(trip.getStatus());
        response.setSeatCount(trip.getSeatCount());
        response.setVehicleCapacity(trip.getVehicleCapacity());
        response.setVehicleType(trip.getVehicleType());
        response.setPrice(trip.getPrice());
        response.setDateTime(trip.getDateTime());
        response.setCreateDate(trip.getCreateDate());
        return response;
    }

    public TripSearchResponse convertToSearchResponse(Trip trip) {
        TripSearchResponse response = new TripSearchResponse();
        response.setFromProvince(trip.getFromProvince());
        response.setToProvince(trip.getToProvince());
        response.setPrice(trip.getPrice());
        response.setStatus(trip.getStatus());
        response.setSeatCount(trip.getSeatCount());
        response.setVehicleType(trip.getVehicleType());
        response.setPrice(trip.getPrice());
        response.setCreateDate(trip.getCreateDate());
        response.setDateTime(trip.getDateTime());
        return response;
    }

    public Trip convert(TripRequest tripRequest) {
        Trip trip= new Trip();
        trip.setFromProvince(tripRequest.getFromProvince());
        trip.setToProvince(tripRequest.getToProvince());
        trip.setPrice(tripRequest.getPrice());
        trip.setStatus(tripRequest.getStatus());
        trip.setSeatCount(tripRequest.getSeatCount());
        trip.setVehicleCapacity(tripRequest.getVehicleCapacity());
        trip.setVehicleType(tripRequest.getVehicleType());
        trip.setPrice(tripRequest.getPrice());
        trip.setCreateDate(LocalDateTime.now());
        trip.setDateTime(tripRequest.getDateTime());
        return trip;
    }

    public List<TripSearchResponse> convert(List<Trip> tripList) {
        List<TripSearchResponse> tripResponse = new ArrayList<>();
        for (Trip trip : tripList) {
            tripResponse.add(convertToSearchResponse(trip));
        }
        return tripList.stream().map(this::convertToSearchResponse).toList();
    }

}
