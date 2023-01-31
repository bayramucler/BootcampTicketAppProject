package com.bootcampprojects.ticketapp.service;

import com.bootcampprojects.ticketapp.client.PaymentServiceClient;
import com.bootcampprojects.ticketapp.client.PaymentStatusType;
import com.bootcampprojects.ticketapp.client.PaymentType;
import com.bootcampprojects.ticketapp.client.request.PaymentRequest;
import com.bootcampprojects.ticketapp.client.response.PaymentResponse;
import com.bootcampprojects.ticketapp.configuration.NotificationQueueConfig;
import com.bootcampprojects.ticketapp.converter.TicketConverter;
import com.bootcampprojects.ticketapp.exception.UserNotFoundException;
import com.bootcampprojects.ticketapp.model.enums.NotificationType;
import com.bootcampprojects.ticketapp.request.NotificationRequest;
import com.bootcampprojects.ticketapp.model.Order;
import com.bootcampprojects.ticketapp.model.Ticket;
import com.bootcampprojects.ticketapp.model.User;
import com.bootcampprojects.ticketapp.model.enums.GenderType;
import com.bootcampprojects.ticketapp.model.enums.UserType;
import com.bootcampprojects.ticketapp.repository.OrderRepository;
import com.bootcampprojects.ticketapp.repository.TicketRepository;
import com.bootcampprojects.ticketapp.request.OrderRequest;
import com.bootcampprojects.ticketapp.request.TicketRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OrderService {
    private static final int MAX_MALE_PASSENGER_COUNT = 2;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TripService tripService;

    @Autowired
    private PaymentServiceClient paymentServiceClient;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private NotificationQueueConfig notificationQueueConfig;

    @Autowired
    private TicketConverter converter;

    @Transactional
    public Order create(OrderRequest orderRequest){
        Logger logger = Logger.getLogger(OrderService.class.getName());
        User foundUser = userService.getById(orderRequest.getUserid()).orElseThrow(() -> new UserNotFoundException("user bulunamadı"));
        Order order = new Order();
        order.setUser(foundUser);
        order.setStatusType(PaymentStatusType.WAITING);
        order.setCreateDate(LocalDateTime.now());
        Order newOrder = orderRepository.save(order);

        List<Ticket> ticketList = createPreparedTicketList(orderRequest.getTicketRequestList(), newOrder, foundUser.getType());
        newOrder.setTicketList(ticketList);
        PaymentStatusType paymentStatusType = performPayment(newOrder.getId(), newOrder.getUser().getId());
        newOrder.setStatusType(paymentStatusType);
        Order savedOrder = orderRepository.save(newOrder);
        logger.log(Level.INFO, "order created: {0}", savedOrder);

        if(paymentStatusType==PaymentStatusType.COMPLETED) {
            NotificationRequest notification = new NotificationRequest();
            notification.setMessage("Satın alma başarılı.");
            notification.setUserid(foundUser.getId());
            notification.setNotificationType(NotificationType.MAIL);
            rabbitTemplate.convertAndSend(notificationQueueConfig.getQueueName(), notification);
        }
        return savedOrder;
    }

    private PaymentStatusType performPayment(int orderId, int userId){
        Logger logger = Logger.getLogger(OrderService.class.getName());
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setOrderid(orderId);
        paymentRequest.setUserid(userId);
        paymentRequest.setPaymentType(PaymentType.CC);
        PaymentResponse paymentResponse = paymentServiceClient.create(paymentRequest);
        logger.log(Level.INFO, "payment performed:{0}", paymentResponse.getStatusType());
        return paymentResponse.getStatusType();
    }

    private List<Ticket> createPreparedTicketList(List<TicketRequest> ticketRequestList, Order order, UserType userType){
        List<Ticket> tickets = new ArrayList<>();
        int malePassengerCount = 0;
        for(TicketRequest ticketRequest: ticketRequestList) {
            if(userType== UserType.INDIVIDUAL && ticketRequest.getPassengerGenderType() == GenderType.MALE)
                malePassengerCount++;
            if(malePassengerCount > MAX_MALE_PASSENGER_COUNT)
                throw new IllegalArgumentException("Bireysel yolcular tek siparişte en fazla 2 erkek yolcu için bilet alabilirler.");
            //TODO: exceptionclasss oluştur
            tickets.add(ticketService.create(ticketRequest, order));
        }

        return tickets;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(Integer orderId) {
        return orderRepository.findById(orderId);
    }

    public Order updatePaymentStatusType(int orderId, PaymentStatusType paymentStatusType) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("order not found: " + orderId));
        order.setStatusType(paymentStatusType);
        return orderRepository.save(order);
    }
}
