package com.invilen.order.orderItem;

import com.invilen.order.dto.OrderRequest;
import com.invilen.order.order.Order;
import com.invilen.order.order.PurchaseRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderItemMapper {

    public OrderItem toOrderItem(PurchaseRequest request, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setQuantity(request.quantity());
        orderItem.setProductId(request.Id());
        return orderItem;
    }
}
