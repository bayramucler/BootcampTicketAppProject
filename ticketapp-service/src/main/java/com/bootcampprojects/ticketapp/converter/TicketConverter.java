package com.bootcampprojects.ticketapp.converter;

import com.bootcampprojects.ticketapp.model.Ticket;
import com.bootcampprojects.ticketapp.request.TicketRequest;
import com.bootcampprojects.ticketapp.response.TicketResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConverter {
    public TicketResponse convert(Ticket ticket) {
        TicketResponse response = new TicketResponse();
        response.setId(ticket.getId());
        response.setPassengerName(ticket.getPassengerName());
        response.setPassengerGenderType(ticket.getPassengerGenderType());
        response.setUserId(ticket.getUser().getId());
        response.setPrice(ticket.getPrice());
        response.setTripId(ticket.getTrip().getId());
        response.setSeatNumber(ticket.getSeatNumber());
        return response;
    }

    public TicketRequest convertTicket(Ticket ticket) {
        TicketRequest request = new TicketRequest();
        request.setPassengerName(ticket.getPassengerName());
        request.setPassengerGenderType(ticket.getPassengerGenderType());
        request.setUserId(ticket.getUser().getId());
        request.setPrice(ticket.getPrice());
        request.setTripId(ticket.getTrip().getId());
        request.setSeatNumber(ticket.getSeatNumber());
        return request;
    }

    public Ticket convert(TicketRequest ticketRequest) {
        Ticket ticket= new Ticket();
        ticket.setCreateDate(LocalDateTime.now());
        ticket.setPrice(ticketRequest.getPrice());
        ticket.setPassengerGenderType(ticketRequest.getPassengerGenderType());
        ticket.setPassengerName(ticketRequest.getPassengerName());
        ticket.setSeatNumber(ticketRequest.getSeatNumber());
        return ticket;
    }

    public List<Ticket> convert(List<TicketRequest> ticketRequestList) {
        List<Ticket> ticketList = new ArrayList<>();
        for (TicketRequest ticketRequest : ticketRequestList) {
            ticketList.add(convert(ticketRequest));
        }
       return ticketList;
    }

}
