package com.bootcampprojects.ticketapp_notification.repository;

import com.bootcampprojects.ticketapp_notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
