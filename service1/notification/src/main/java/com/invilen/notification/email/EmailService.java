package com.invilen.notification.email;

import com.invilen.notification.dto.OrderConfirmation;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_RELATED;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendOrderSuccess(OrderConfirmation orderConfirmation) throws MessagingException {
        var destinationEmail = orderConfirmation.customer().email();
        var customerName = orderConfirmation.customer().firstName() + " " + orderConfirmation.customer().lastName();
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper =
                new MimeMessageHelper(mimeMessage, MULTIPART_MODE_RELATED, UTF_8.name());
        messageHelper.setFrom("adnanmohd4509@gmail.com");

        final String templateName = "order-confirmation.html";

        Map<String, Object> variables = new HashMap<>();
        variables.put("customerName", customerName);
        variables.put("totalAmount", orderConfirmation.totalAmount());
        variables.put("orderReference", orderConfirmation.orderReference());
        variables.put("products", orderConfirmation.purchasedProducts());

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject("Order placed successfully");

        try{
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s", destinationEmail, templateName));

        }catch (MessagingException e) {
            log.warn("WARNING - Cannot send  email to {}", destinationEmail);
        }
    }
}
