package com.bootcampprojects.ticketapp.repository;

import java.time.LocalDateTime;

public interface TripInfoProjection {
     Integer getTicketId();
     String getPassengerName();
     double getPrice();
     Integer getOrderId();
     LocalDateTime getCreateDate();
}
