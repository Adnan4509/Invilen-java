package com.invilens.bakery.dto;

import com.invilens.bakery.bakery.Category;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record BakeryRequest(

        String description,
        @NotEmpty(message = "name cannot be empty")
        String name,
        String weight,
        @NotEmpty(message = "quantity cannot be empty")
        Double Quantity,
        @NotEmpty(message = "price cannot be empty")
        BigDecimal price,
        @NotEmpty(message = "category cannot be empty")
        Category category
) {
}
