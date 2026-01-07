package com.invilens.bakery.dto;

import com.invilens.bakery.Category;

import java.math.BigDecimal;

public record BakeryResponse(
        Integer id,
        String description,
        String name,
        String weight,
        Double Quantity,
        BigDecimal price,
        Category category
) {
}
