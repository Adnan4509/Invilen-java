package com.invilen.notification.kafkaConsumer;

import com.invilen.notification.dto.OrderConfirmation;
import com.invilen.notification.email.EmailService;
import com.invilen.notification.notification.Notification;
import com.invilen.notification.notification.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationConsumer {
    private final NotificationRepository repository;
    private final EmailService emailService;

    @KafkaListener(topics = "order-topic")
    public void sendNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Successfully fetcched data from kafka");
            repository.save(Notification.builder()
                    .notificationDate(LocalDateTime.now())
                    .orderConfirmation(orderConfirmation)
                    .build()
            );
            log.info("Successfully saved to database");

        emailService.sendOrderSuccess(orderConfirmation);
        log.info("successfully send email to {}",orderConfirmation.customer().email());
    }
}
