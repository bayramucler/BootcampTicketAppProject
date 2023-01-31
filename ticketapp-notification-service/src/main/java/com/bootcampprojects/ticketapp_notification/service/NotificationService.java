package com.bootcampprojects.ticketapp_notification.service;
import com.bootcampprojects.ticketapp_notification.model.Notification;
import com.bootcampprojects.ticketapp_notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public Notification create(Notification notification){
        return notificationRepository.save(notification);
    }
}
