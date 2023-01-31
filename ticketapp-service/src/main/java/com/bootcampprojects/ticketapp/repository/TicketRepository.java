package com.bootcampprojects.ticketapp.repository;

import com.bootcampprojects.ticketapp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> getTicketListByTripIdAndUserId(Integer tripId, Integer userId);

    @Query( value =
            " select 											  "+
            " 	tr.from_province fromProvince,                    "+
            " 	tr.to_province toProvince,                        "+
            " 	tr.date_time dateTime,                            "+
            " 	tr.vehicle_type vehicleType,                      "+
            " 	t.passenger_name passengerName,                   "+
            " 	t.passenger_gender_type passengerGenderType,      "+
            " 	t.seat_number seatNumber,                         "+
            " 	t.price price,                                    "+
            " 	t.create_date createDate                          "+
            " from                                                "+
            " 	ticket t                                          "+
            " inner join                                          "+
            " 	orders o on t.order_id = o.id and o.status_type =1"+
            " left join 	                                      "+
            " 	trip tr on t.trip_id =tr.id                       "+
            " where 	                                          "+
            " 	t.user_id =:user_id                               ",
            nativeQuery = true)
    List<TicketInfoProjection> getTicketInfoByUserid(@Param("user_id") Integer userId);
}
