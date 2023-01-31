package com.bootcampprojects.ticketapp.repository;

import com.bootcampprojects.ticketapp.model.enums.GenderType;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;
import java.time.LocalDateTime;

public interface TicketInfoProjection {
     String getFromProvince();
     String getToProvince();
     LocalDateTime getDateTime();
     VehicleType getVehicleType();
     String getPassengerName();
     GenderType getPassengerGenderType();
     Integer getSeatNumber();
     double getPrice();
     LocalDateTime getCreateDate();
}
