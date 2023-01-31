package com.bootcampprojects.ticketapp.model;

import com.bootcampprojects.ticketapp.client.PaymentStatusType;
import com.bootcampprojects.ticketapp.model.enums.OrderStatusType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private PaymentStatusType statusType;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> ticketList;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createDate;

    public Order() {
    }

    public Order(Integer id, User user, List<Ticket> ticketList) {
        this.id = id;
        this.user = user;
        this.ticketList = ticketList;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public PaymentStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(PaymentStatusType statusType) {
        this.statusType = statusType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", statusType=" + statusType +
                ", user=" + user +
                ", ticketList=" + ticketList +
                ", createDate=" + createDate +
                '}';
    }
}
