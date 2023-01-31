package com.bootcampprojects.ticketapp.request;

import com.bootcampprojects.ticketapp.model.enums.NotificationType;

public class NotificationRequest {
    private String message;
    private NotificationType notificationType;
    private Integer userid;

    public NotificationRequest() {
    }

    public NotificationRequest(String message, NotificationType notificationType, Integer userid) {
        this.message = message;
        this.notificationType = notificationType;
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                ", message='" + message + '\'' +
                ", notificationType=" + notificationType +
                ", userid=" + userid +
                '}';
    }
}
