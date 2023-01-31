package com.bootcampprojects.ticketapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({ FeignAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "TicketApp Service API", version = "1.0", description = "TicketApp Service API Information"))
public class TicketappApplication {
	public static void main(String[] args) {
		SpringApplication.run(TicketappApplication.class, args);
	}
}
