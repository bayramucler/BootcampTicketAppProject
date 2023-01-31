package com.bootcampprojects.ticketapp_notification.model;

import com.bootcampprojects.ticketapp_notification.model.enums.NotificationType;

import javax.persistence.*;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String message;
    private NotificationType notificationType;
    private Integer userid;

    public Notification() {
    }

    public Notification(Integer id, String message, NotificationType notificationType, Integer userid) {
        this.id = id;
        this.message = message;
        this.notificationType = notificationType;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "Notification{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", notificationType=" + notificationType +
                ", userid=" + userid +
                '}';
    }
}
