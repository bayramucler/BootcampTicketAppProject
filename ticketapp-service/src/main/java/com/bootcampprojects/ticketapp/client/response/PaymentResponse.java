package com.bootcampprojects.ticketapp.client.response;

import com.bootcampprojects.ticketapp.client.PaymentStatusType;

public class PaymentResponse {
    private Integer id;
    private Integer userid;
    private Integer orderid;
    private String creditNumber;
    private PaymentStatusType statusType;

    public PaymentResponse() {
    }

    public PaymentResponse(Integer id, Integer userid, Integer orderid, String creditNumber, PaymentStatusType statusType) {
        this.id = id;
        this.userid = userid;
        this.orderid = orderid;
        this.creditNumber = creditNumber;
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


    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public PaymentStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(PaymentStatusType statusType) {
        this.statusType = statusType;
    }
}
