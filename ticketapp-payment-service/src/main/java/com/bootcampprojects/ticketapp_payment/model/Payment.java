package com.bootcampprojects.ticketapp_payment.model;

import com.bootcampprojects.ticketapp_payment.model.enums.PaymentStatusType;
import com.bootcampprojects.ticketapp_payment.model.enums.PaymentType;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer userid;
    private Integer orderid;
    private PaymentStatusType statusType;
    private PaymentType paymentType;

    public Payment() {
    }

    public Payment(Integer id, Integer userid, Integer orderid, String creditNumber, PaymentStatusType statusType) {
        this.id = id;
        this.userid = userid;
        this.orderid = orderid;
        this.statusType = statusType;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(PaymentStatusType statusType) {
        this.statusType = statusType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
