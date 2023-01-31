package com.bootcampprojects.ticketapp.model;
import com.bootcampprojects.ticketapp.model.enums.TripStatusType;
import com.bootcampprojects.ticketapp.model.enums.VehicleType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "fromProvince", nullable = false)
    private String fromProvince;
    @Column(name = "toProvince", nullable = false)
    private String toProvince;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> ticketList;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TripStatusType status;
    @Column(name = "vehicleType")
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @Column(name = "vehicleCapacity", nullable = false)
    private short vehicleCapacity;
    @Column(name = "seatCount", nullable = false)
    private short seatCount;
    @Column(name = "price", nullable = false)
    private double price;


    public Trip() {
    }

    public Trip(String fromProvince, String toProvince, LocalDateTime createDate, User user, List<Ticket> ticketList, TripStatusType status, VehicleType vehicleType, short vehicleCapacity, short seatCount, double price) {
        this.fromProvince = fromProvince;
        this.toProvince = toProvince;
        this.createDate = createDate;
        this.user = user;
        this.ticketList = ticketList;
        this.status = status;
        this.vehicleType = vehicleType;
        this.vehicleCapacity = vehicleCapacity;
        this.seatCount = seatCount;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(String fromProvince) {
        this.fromProvince = fromProvince;
    }

    public String getToProvince() {
        return toProvince;
    }

    public void setToProvince(String toProvince) {
        this.toProvince = toProvince;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public TripStatusType getStatus() {
        return status;
    }

    public void setStatus(TripStatusType status) {
        this.status = status;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public short getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(short vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public short getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(short seatCount) {
        this.seatCount = seatCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
