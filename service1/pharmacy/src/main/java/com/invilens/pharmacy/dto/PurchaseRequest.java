package com.invilens.pharmacy.dto;

public record PurchaseRequest(
        Integer productId,
        Double quantity
) {
}
