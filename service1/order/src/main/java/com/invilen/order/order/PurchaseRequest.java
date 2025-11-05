package com.invilen.order.order;

import jakarta.validation.constraints.NotNull;

public record PurchaseRequest(
        @NotNull(message = "Product Id cannot be null")
        Integer Id,
        @NotNull(message = "Quantity cannot be null")
        double quantity
) {
}
