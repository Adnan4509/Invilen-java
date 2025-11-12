package com.invilens.pharmacy.dto;

import com.invilens.pharmacy.pharmacy.Category;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PharmacyRequest(
        @NotNull(message = "name cannot be empty")
        String name,
        @NotNull(message = "Description cannot be empty")
        String description,
        @NotNull(message = "brand cannot be empty")
        String brand,
        @NotNull(message = "Dosage cannot be empty")
        String dosage,
        @NotNull(message = "quantity cannot be empty")
        Double quantity,
        @NotNull(message = "price cannot be empty")
        BigDecimal price,
        @NotNull(message = "expiry-date cannot be empty")
        LocalDate expiry_date,
        @NotNull(message = "category cannot be empty")
        Category category
) {
}
