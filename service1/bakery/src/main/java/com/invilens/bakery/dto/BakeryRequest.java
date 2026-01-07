package com.invilens.bakery.dto;

import com.invilens.bakery.bakery.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record BakeryRequest(

        String description,
        @NotEmpty(message = "name cannot be empty")
        String name,
        String weight,
        @NotNull(message = "quantity cannot be empty")
        Double Quantity,
        @NotNull(message = "price cannot be empty")
        BigDecimal price,
        @NotNull(message = "category cannot be empty")
        Category category
) {
}
