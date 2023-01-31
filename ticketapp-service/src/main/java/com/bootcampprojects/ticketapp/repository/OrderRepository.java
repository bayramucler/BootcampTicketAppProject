package com.bootcampprojects.ticketapp.repository;

import com.bootcampprojects.ticketapp.model.Order;
import com.bootcampprojects.ticketapp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
