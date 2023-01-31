package com.bootcampprojects.ticketapp_payment.client;

import com.bootcampprojects.ticketapp_payment.model.enums.PaymentStatusType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "ticketapp-service", url = "http://localhost:8080")
public interface OrderServiceClient {

    @PutMapping(value = "/order/{orderId}/paymentstatus")
    String updatePaymentStatusType(@PathVariable int orderId, @RequestBody PaymentStatusType paymentStatusType);

}
