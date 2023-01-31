package com.bootcampprojects.ticketapp.service;

import com.bootcampprojects.ticketapp.converter.TicketConverter;
import com.bootcampprojects.ticketapp.exception.*;
import com.bootcampprojects.ticketapp.model.*;
import com.bootcampprojects.ticketapp.model.Ticket;
import com.bootcampprojects.ticketapp.model.enums.UserType;
import com.bootcampprojects.ticketapp.repository.TicketInfoProjection;
import com.bootcampprojects.ticketapp.repository.TicketRepository;
import com.bootcampprojects.ticketapp.repository.TripInfoProjection;
import com.bootcampprojects.ticketapp.request.TicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @Autowired
    private TicketConverter converter;

    @Transactional
    public Ticket create(TicketRequest ticketRequest, Order order){
        User foundUser = userService.getById(ticketRequest.getUserId()).orElseThrow(() -> new UserNotFoundException("user bulunamadı"));
        Trip foundTrip = tripService.getById(ticketRequest.getTripId()).orElseThrow(() -> new TripNotFoundException("sefer bulunamadı"));
        validateSeatCount(foundTrip.getSeatCount());
        validatePurchasingTicketByUser(foundTrip.getId(), foundUser.getId(), foundUser.getType());
        Ticket ticket = converter.convert(ticketRequest);
        ticket.setUser(foundUser);
        ticket.setTrip(foundTrip);
        ticket.setOrder(order);
        Ticket savedTicket = ticketRepository.save(ticket);
        tripService.decrementSeatCount(foundTrip);
        return savedTicket;
    }

    private void validatePurchasingTicketByUser(int tripId, int userId, UserType userType){
        List<Ticket> ticketList = getTicketListByTripIdAndUserId(tripId, userId);
        if(userType == UserType.INDIVIDUAL && ticketList.size() >= 5)
            throw new IndividualTicketLimitException("Bireysel kullanıcı aynı sefer için en fazla 5 bilet alabilir.");

        if(userType == UserType.CORPARETE && ticketList.size() >= 20)
            throw new CorpareteTicketLimitException("Kurumsal kullanıcı aynı sefer için en fazla 20 bilet alabilir.");
    }

    private void validateSeatCount(int seatCount){
        if(seatCount<1)
            throw new AvailableSeatNotFoundException("Bu sefer için boş koltuk bulunamamaktadır.");
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketListByTripIdAndUserId(Integer tripId, Integer userId){
        return ticketRepository.getTicketListByTripIdAndUserId(tripId, userId);
    }

    public List<TicketInfoProjection> getTicketInfoByUserId(Integer userId){
        return ticketRepository.getTicketInfoByUserid(userId);
    }

}
