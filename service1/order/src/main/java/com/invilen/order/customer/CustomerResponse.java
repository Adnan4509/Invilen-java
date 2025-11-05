package com.invilen.order.customer;


public record CustomerResponse(
        String firstName,
        String lastName,
        String email
) {
}
