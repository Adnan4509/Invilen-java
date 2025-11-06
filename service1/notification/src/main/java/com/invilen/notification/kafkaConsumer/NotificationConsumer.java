package com.invilen.notification.kafkaConsumer;

import com.invilen.notification.dto.OrderConfirmation;
import com.invilen.notification.email.EmailService;
import com.invilen.notification.notification.Notification;
import com.invilen.notification.notification.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationConsumer {
    private final NotificationRepository repository;
    private final EmailService emailService;

    @KafkaListener(topics = "order-topic")
    public void sendNotification(OrderConfirmation orderConfirmation) {
        System.out.println("Successfully fetched from kafka");
        repository.save(Notification.builder()
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        System.out.println("SAVED TO NOTIFICATION DATABASE");
        emailService.sendOrderSuccess(orderConfirmation);
        System.out.println("Successfully send order confirmation email");
    }
}
