package com.bootcampprojects.ticketapp_notification.listener;

import com.bootcampprojects.ticketapp_notification.model.Notification;
import com.bootcampprojects.ticketapp_notification.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {
	@Autowired
	private NotificationService notificationService;

	@RabbitListener(queues = "ticketapp.notification")
	public void notificationListener(Notification notification) {
		System.out.println("***** notif: " + notification);
		notificationService.create(notification);
	}
}
