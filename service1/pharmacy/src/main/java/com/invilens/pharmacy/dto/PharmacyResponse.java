package com.invilens.pharmacy.dto;

import com.invilens.pharmacy.pharmacy.Category;

import java.math.BigDecimal;
import java.time.LocalDate;


public record PharmacyResponse(
        Integer id,
        String name,
        String description,
        String brand,
        String dosage,
        Double quantity,
        BigDecimal price,
        LocalDate expiry_date,
        Category category
) {
}
