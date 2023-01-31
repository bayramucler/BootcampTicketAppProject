package com.bootcampprojects.ticketapp.model;

import com.bootcampprojects.ticketapp.model.enums.UserRoleType;
import com.bootcampprojects.ticketapp.model.enums.UserType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})},
                      indexes = {  @Index(name = "eMail_index", columnList = "email") })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType type;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRoleType roleType;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Trip> tripList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> ticketList;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createDate;


    public User() {
    }

    public User(String name, String email, String password, UserType type, UserRoleType roleType, List<Trip> tripList, List<Ticket> ticketList, LocalDateTime createDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.roleType = roleType;
        this.tripList = tripList;
        this.ticketList = ticketList;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserRoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(UserRoleType roleType) {
        this.roleType = roleType;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}