package com.bootcampprojects.ticketapp_payment.request;


import com.bootcampprojects.ticketapp_payment.model.enums.PaymentStatusType;
import com.bootcampprojects.ticketapp_payment.model.enums.PaymentType;

public class PaymentRequest {
    private Integer userid;
    private Integer orderid;
    private PaymentStatusType paymentStatusType;
    private PaymentType paymentType;


    public PaymentRequest() {
    }

    public PaymentRequest(Integer userid, Integer orderid, PaymentStatusType paymentStatusType, String creditNumber) {
        this.userid = userid;
        this.orderid = orderid;
        this.paymentStatusType = paymentStatusType;
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

    public PaymentStatusType getPaymentStatusType() {
        return paymentStatusType;
    }

    public void setPaymentStatusType(PaymentStatusType paymentStatusType) {
        this.paymentStatusType = paymentStatusType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
