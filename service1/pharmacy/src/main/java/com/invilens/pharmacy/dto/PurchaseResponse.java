package com.invilens.pharmacy.dto;

import com.invilens.pharmacy.pharmacy.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PurchaseResponse(
        Integer id,
        String name,
        String brand,
        Double quantity,
        BigDecimal price,
        LocalDate expiry_date
) {
}
