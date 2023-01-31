package com.bootcampprojects.ticketapp_payment.repository;

import com.bootcampprojects.ticketapp_payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
