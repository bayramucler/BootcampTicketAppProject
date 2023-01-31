package com.bootcampprojects.ticketapp.model;

import com.bootcampprojects.ticketapp.model.enums.GenderType;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name  = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "passengerName", nullable = false)
    private String passengerName;
    @Column(name = "passengerGenderType")
    @Enumerated(EnumType.STRING)
    private GenderType passengerGenderType;
    @Column(name = "seatNumber", nullable = false)
    private short seatNumber;
    @Column(name = "price", nullable = false)
    private double price;
    @OneToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id", nullable = false)
    private Trip trip;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createDate;

    public Ticket() {
    }

    public Ticket(String passengerName, GenderType passengerGenderType, short seatNumber, double price, Trip trip, User user) {
        this.passengerName = passengerName;
        this.passengerGenderType = passengerGenderType;
        this.seatNumber = seatNumber;
        this.price = price;
        this.trip = trip;
        this.user = user;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public GenderType getPassengerGenderType() {
        return passengerGenderType;
    }

    public void setPassengerGenderType(GenderType passengerGenderType) {
        this.passengerGenderType = passengerGenderType;
    }

    public short getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(short seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
