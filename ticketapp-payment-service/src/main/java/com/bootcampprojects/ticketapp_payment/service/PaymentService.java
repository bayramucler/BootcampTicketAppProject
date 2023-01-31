package com.bootcampprojects.ticketapp_payment.service;

import com.bootcampprojects.ticketapp_payment.client.OrderServiceClient;
import com.bootcampprojects.ticketapp_payment.model.Payment;
import com.bootcampprojects.ticketapp_payment.model.enums.PaymentStatusType;
import com.bootcampprojects.ticketapp_payment.repository.PaymentRepository;
import com.bootcampprojects.ticketapp_payment.request.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderServiceClient orderServiceClient;

    public Payment create(PaymentRequest paymentRequest){
        Payment payment = new Payment();
        payment.setUserid(paymentRequest.getUserid());
        payment.setOrderid(paymentRequest.getOrderid());
        payment.setStatusType(PaymentStatusType.COMPLETED);
        payment.setPaymentType(paymentRequest.getPaymentType());
        return paymentRepository.save(payment);
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
}
