package com.invilen.order.dto;

import com.invilen.order.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public OrderResponse toResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getCustomerId()
        );
    }

    public Order toOrder(OrderRequest request) {
        Order order = new Order();
        order.setId(request.id());
        order.setReference(request.reference());
        order.setCustomerId(request.customerId());
        order.setTotalAmount(request.amount());
        return order;
    }
}
