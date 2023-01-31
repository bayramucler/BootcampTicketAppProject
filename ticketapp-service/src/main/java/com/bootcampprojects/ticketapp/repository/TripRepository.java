package com.bootcampprojects.ticketapp.repository;

import com.bootcampprojects.ticketapp.model.Ticket;
import com.bootcampprojects.ticketapp.model.Trip;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;
import com.bootcampprojects.ticketapp.response.TripResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    List<Trip> getTripListByFromProvinceAndToProvince(String fromProvince, String toProvince);

    @Transactional
    @Modifying
    @Query(value = "update trip set seat_count = seat_count-1 where id=:id", nativeQuery = true)
    void decrementSeatCount(@Param("id") Integer id);

    @Query( value = "select " +
            " t.id as ticketId, t.passenger_name passengerName, t.price, o.id as orderId, o.create_date createDate" +
            " from" +
            " ticket t" +
            " inner join" +
            " orders o on t.order_id=o.id and o.status_type =1" +
            " where" +
            " t.trip_id = :trip_id", nativeQuery = true)
    List<TripInfoProjection> getTripInfoByTripId(@Param("trip_id") Integer tripId);

    @Query( value = "select " +
            " sum(price) totalAmount" +
            " from" +
            " ticket t" +
            " inner join" +
            " orders o on t.order_id=o.id and o.status_type =1" +
            " where" +
            " t.trip_id = :trip_id", nativeQuery = true)
    TotalAmountTripInfoProjection getTotalAmountByTripId(@Param("trip_id") Integer tripId);

    List<Trip> getTripListByVehicleType(VehicleType vehicleType);

    List<Trip> getTripListByDateTime(LocalDateTime dateTime);
}
