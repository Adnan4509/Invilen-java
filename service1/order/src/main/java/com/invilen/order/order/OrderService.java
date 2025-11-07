package com.invilen.order.order;

import com.invilen.order.customer.CustomerClient;
import com.invilen.order.dto.OrderMapper;
import com.invilen.order.dto.OrderRequest;
import com.invilen.order.dto.OrderResponse;
import com.invilen.order.kafka.NotificationProducer;
import com.invilen.order.kafka.OrderConfirmation;
import com.invilen.order.orderItem.OrderItemMapper;
import com.invilen.order.orderItem.OrderItemRepository;
import com.invilen.order.product.ProductClient;
import com.invilen.order.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderItemRepository itemRepository;
    private final OrderItemMapper itemMapper;
    private final NotificationProducer notificationProducer;

    public Page<OrderResponse> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable)
                .map(mapper::toResponse);

    }

    public OrderResponse findById(Integer orderId) {
        return mapper.toResponse(repository.findById(orderId).orElseThrow());
    }

    public Integer createOrder(OrderRequest request) {
//        step-1: customer data
        var customer = customerClient.findCustomerById(request.customerId());
        System.out.println(customer);
//        step-2: product purchase from product ms
        var purchasedProducts = productClient.purchaseProduct(request.products());
        System.out.println(purchasedProducts);
//        step-3:save order
        var order = repository.save(mapper.toOrder(request));
        System.out.println(order);
//        step-4: save order items
        for(PurchaseRequest purchaseRequest: request.products()) {
            var orderItem = itemRepository.save(itemMapper.toOrderItem(purchaseRequest, order));
        }
//        step-5: send order confirmation
        var orderConfirmation = new OrderConfirmation(
                request.reference(),
                customer,
                purchasedProducts,
                request.amount()
        );
        notificationProducer.sendOrderConfirmation(orderConfirmation);
        return order.getId();
    }
}
