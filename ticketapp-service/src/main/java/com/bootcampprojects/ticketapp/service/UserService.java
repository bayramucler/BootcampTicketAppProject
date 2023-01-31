package com.bootcampprojects.ticketapp.service;

import com.bootcampprojects.ticketapp.configuration.NotificationQueueConfig;
import com.bootcampprojects.ticketapp.converter.UserConverter;
import com.bootcampprojects.ticketapp.exception.UserNotFoundException;
import com.bootcampprojects.ticketapp.model.User;
import com.bootcampprojects.ticketapp.model.enums.NotificationType;
import com.bootcampprojects.ticketapp.repository.UserRepository;
import com.bootcampprojects.ticketapp.request.LoginRequest;
import com.bootcampprojects.ticketapp.request.NotificationRequest;
import com.bootcampprojects.ticketapp.request.UserRequest;
import com.bootcampprojects.ticketapp.response.UserResponse;
import com.bootcampprojects.ticketapp.util.PasswordUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {
    private static final String EMAIL_VEYA_ŞIFRE_YANLIŞ = "Email veya şifre yanlış";

    private static final String LOGIN_BAŞARILI = "Login Başarılı";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter converter;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private NotificationQueueConfig notificationQueueConfig;


    public UserResponse create(UserRequest userRequest){
        String hash = PasswordUtil.preparePasswordHash(userRequest.getPassword(), userRequest.getEmail());
        User savedUser = userRepository.save(converter.convert(userRequest, hash));

        NotificationRequest notification = new NotificationRequest();
        notification.setMessage("Kullanıcı kaydı başarılı.");
        notification.setUserid(savedUser.getId());
        notification.setNotificationType(NotificationType.SMS);
        rabbitTemplate.convertAndSend(notificationQueueConfig.getQueueName(), notification);

        return converter.convert(savedUser);
    }

    public Optional<User> getById(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public String login(LoginRequest loginRequest) {
        User foundUser = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UserNotFoundException("kullanıcı bulunamadı"));
        String passwordHash = PasswordUtil.preparePasswordHash(loginRequest.getPassword(), loginRequest.getEmail());
        boolean isValid = PasswordUtil.validatePassword(passwordHash, foundUser.getPassword());
        return isValid ? LOGIN_BAŞARILI : EMAIL_VEYA_ŞIFRE_YANLIŞ;
    }

}
