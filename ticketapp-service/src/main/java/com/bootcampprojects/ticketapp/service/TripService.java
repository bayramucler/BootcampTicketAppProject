package com.bootcampprojects.ticketapp.service;

import com.bootcampprojects.ticketapp.converter.TripConverter;
import com.bootcampprojects.ticketapp.exception.AuthorizationException;
import com.bootcampprojects.ticketapp.exception.TripNotFoundException;
import com.bootcampprojects.ticketapp.exception.UserNotFoundException;
import com.bootcampprojects.ticketapp.model.Trip;
import com.bootcampprojects.ticketapp.model.User;
import com.bootcampprojects.ticketapp.model.enums.UserRoleType;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;
import com.bootcampprojects.ticketapp.repository.TotalAmountTripInfoProjection;
import com.bootcampprojects.ticketapp.repository.TripInfoProjection;
import com.bootcampprojects.ticketapp.repository.TripRepository;
import com.bootcampprojects.ticketapp.repository.UserRepository;
import com.bootcampprojects.ticketapp.request.TripRequest;
import com.bootcampprojects.ticketapp.request.UpdateTripStatusRequest;
import com.bootcampprojects.ticketapp.response.TripResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private TripConverter converter;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    public TripResponse create(TripRequest tripRequest){
        User foundUser = userService.getById(tripRequest.getUserId()).orElseThrow(() -> new IllegalStateException("user bulunamadı"));
        if(foundUser.getRoleType() != UserRoleType.ADMIN){
            throw new AuthorizationException("Sadece Admin kullanıcılar sefer ekleyebilir");
        }
        Trip trip = converter.convert(tripRequest);
        trip.setUser(foundUser);
        Trip savedTrip = tripRepository.save(trip);
        List<Trip> userTripList = new ArrayList<Trip>();
        userTripList.add(savedTrip);
        foundUser.setTripList(userTripList);
        userRepository.save(foundUser);
        return converter.convert(savedTrip);
    }

    public TripResponse updateStatus(UpdateTripStatusRequest updateTripStatusRequest){
        User foundUser = userService.getById(updateTripStatusRequest.getUserId()).orElseThrow(() -> new UserNotFoundException("user bulunamadı"));
        Trip foundTrip = tripRepository.findById(updateTripStatusRequest.getTripId()).orElseThrow(() -> new TripNotFoundException("sefer bulunamadı"));
        if(foundUser.getRoleType() != UserRoleType.ADMIN){
            throw new AuthorizationException("Sadece Admin kullanıcılar sefer güncelleyebilir");
        }
        foundTrip.setStatus(updateTripStatusRequest.getStatus());
        Trip savedTrip = tripRepository.save(foundTrip);
        return converter.convert(savedTrip);
    }

    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getById(Integer tripId) {
        return tripRepository.findById(tripId);
    }

    /*
     * @deprecated Transactional yapı nedeniyle deprecated edildi.
     */
    @Deprecated
    public void decrementSeatCount(Integer tripId){
        tripRepository.decrementSeatCount(tripId);
    }

    public void decrementSeatCount(Trip trip){
        trip.setSeatCount((short) (trip.getSeatCount() - 1));
        tripRepository.save(trip);
    }

    public void update(Trip trip){
        tripRepository.save(trip);
    }

    public List<TripInfoProjection> getTripInfoByTripId(Integer tripId){
        return tripRepository.getTripInfoByTripId(tripId);
    }

    public TotalAmountTripInfoProjection getTotalAmountTripInfoByTripId(Integer tripId){
        return tripRepository.getTotalAmountByTripId(tripId);
    }

    public List<Trip> getTripListByFromProvinceAndToProvince(String fromProvince, String toProvince){
        return tripRepository.getTripListByFromProvinceAndToProvince(fromProvince, toProvince);
    }

    public List<Trip> getTripListByVehicleType(VehicleType vehicleType) {
        return tripRepository.getTripListByVehicleType(vehicleType);
    }

    public List<Trip> getTripListByDateTime(LocalDateTime dateTime) {
        return tripRepository.getTripListByDateTime(dateTime);

    }
}
