package com.invilen.order.product;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PurchaseResponse(
        String name,
        String brand,
        Double quantity,
        BigDecimal price,
        LocalDate expiry_date
) {
}
