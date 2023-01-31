package com.bootcampprojects.ticketapp.controller;


import com.bootcampprojects.ticketapp.converter.TripConverter;
import com.bootcampprojects.ticketapp.model.Trip;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;
import com.bootcampprojects.ticketapp.repository.TotalAmountTripInfoProjection;
import com.bootcampprojects.ticketapp.repository.TripInfoProjection;
import com.bootcampprojects.ticketapp.request.TripRequest;
import com.bootcampprojects.ticketapp.request.UpdateTripStatusRequest;
import com.bootcampprojects.ticketapp.response.TripResponse;
import com.bootcampprojects.ticketapp.response.TripSearchResponse;
import com.bootcampprojects.ticketapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value ="/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @Autowired
    private TripConverter tripConverter;

    @GetMapping
    public ResponseEntity<List<Trip>> getAll() {
        return ResponseEntity.ok(tripService.getAll());
    }

    @GetMapping(value="/purchased/{tripId}")
    public ResponseEntity<List<TripInfoProjection>> getAllTripInfo(@PathVariable int tripId) {
        return ResponseEntity.ok(tripService.getTripInfoByTripId(tripId));
    }

    @GetMapping(value="/purchased/totalAmount/{tripId}")
    public ResponseEntity<TotalAmountTripInfoProjection> getTotalAmountTripInfo(@PathVariable int tripId) {
        return ResponseEntity.ok(tripService.getTotalAmountTripInfoByTripId(tripId));
    }

    @GetMapping("/search/province")
    public ResponseEntity<List<TripSearchResponse>> getTripListByFromProvinceAndToProvince(@RequestParam(value="fromProvince") String fromProvince, @RequestParam(value="toProvince") String toProvince) {
        return ResponseEntity.ok(tripConverter.convert(tripService.getTripListByFromProvinceAndToProvince(fromProvince, toProvince)));
    }

    @GetMapping("/search/vehicleType")
    public ResponseEntity<List<TripSearchResponse>> getTripListByVehicleType(@RequestParam(value="vehicleType") VehicleType vehicleType) {
        return ResponseEntity.ok(tripConverter.convert(tripService.getTripListByVehicleType(vehicleType)));
    }

    @GetMapping("/search/datetime/{dateTime}")
    public ResponseEntity<List<TripSearchResponse>> getTripListByDateTime(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {
        return ResponseEntity.ok(tripConverter.convert(tripService.getTripListByDateTime(dateTime)));
    }

    @PostMapping
    public ResponseEntity<TripResponse> create(@RequestBody TripRequest tripRequest) {
        TripResponse tripResponse = tripService.create(tripRequest);
        return ResponseEntity.ok(tripResponse);
    }

    @PutMapping
    public ResponseEntity<TripResponse> updateStatus(@RequestBody UpdateTripStatusRequest updateTripStatusRequest) {
        TripResponse tripResponse = tripService.updateStatus(updateTripStatusRequest);
        return ResponseEntity.ok(tripResponse);
    }

}
