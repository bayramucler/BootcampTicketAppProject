package com.bootcampprojects.ticketapp.client;


import com.bootcampprojects.ticketapp.client.request.PaymentRequest;
import com.bootcampprojects.ticketapp.client.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "ticketapp-payment-service", url = "http://localhost:8082")
public interface PaymentServiceClient {
	@PostMapping(value = "/payment")
	PaymentResponse create(@RequestBody PaymentRequest payment);
}
