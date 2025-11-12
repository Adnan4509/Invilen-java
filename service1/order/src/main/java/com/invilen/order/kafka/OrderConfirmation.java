package com.invilen.order.kafka;

import com.invilen.order.customer.CustomerResponse;
import com.invilen.order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        CustomerResponse customer,
        List<PurchaseResponse> purchasedProducts,
        BigDecimal totalAmount

) {
}
