package com.invilen.notification.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        CustomerResponse customer,
        List<PurchaseResponse> purchasedProducts,
        BigDecimal totalAmount
) {
}
