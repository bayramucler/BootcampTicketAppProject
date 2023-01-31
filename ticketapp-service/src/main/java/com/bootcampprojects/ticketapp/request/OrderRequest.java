package com.bootcampprojects.ticketapp.request;


import com.bootcampprojects.ticketapp.model.Ticket;
import com.bootcampprojects.ticketapp.model.User;

import java.util.List;

public class OrderRequest {
    private Integer userid;
    private List<TicketRequest> ticketRequestList;

    public OrderRequest() {
    }

    public OrderRequest(Integer userid, List<TicketRequest> ticketRequestList) {
        this.userid = userid;
        this.ticketRequestList = ticketRequestList;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public List<TicketRequest> getTicketRequestList() {
        return ticketRequestList;
    }

    public void setTicketRequestList(List<TicketRequest> ticketRequestList) {
        this.ticketRequestList = ticketRequestList;
    }
}
