package com.invilen.notification.notification;


import com.invilen.notification.dto.OrderConfirmation;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@Builder
public class Notification {
    @Id
    private String id;
//    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
//    private PaymentConfirmation paymentConfirmation;
}
