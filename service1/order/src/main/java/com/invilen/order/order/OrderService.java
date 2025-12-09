package com.invilen.order.order;

import com.invilen.order.customer.CustomerClient;
import com.invilen.order.dto.*;
import com.invilen.order.exception.BusinessException;
import com.invilen.order.exception.ProductNotFoundException;
import com.invilen.order.kafka.NotificationProducer;
import com.invilen.order.kafka.OrderConfirmation;
import com.invilen.order.orderItem.OrderItemMapper;
import com.invilen.order.orderItem.OrderItemRepository;
import com.invilen.order.product.ProductServiceResolver;
import com.invilen.order.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CustomerClient customerClient;
    private final ProductServiceResolver productServiceResolver;
    private final OrderItemRepository itemRepository;
    private final OrderItemMapper itemMapper;
    private final NotificationProducer notificationProducer;

    public Page<OrderResponse> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable)
                .map(mapper::toResponse);

    }

    public OrderResponse findById(Integer orderId) {
        return mapper.toResponse(repository.findById(orderId).orElseThrow(
                () -> new ProductNotFoundException("Product not found with the provided ID")
        ));
    }

    public Integer createOrder(OrderRequest request) {
//        step-1: customer data
        var customer = customerClient.findCustomerById(request.customerId())
                        .orElseThrow(() -> new BusinessException("Cannot find customer with the provided ID"));
//        step-2: product purchase from product ms
        var client = productServiceResolver.getClient(request.productType());
        var purchasedProducts = client.getProductById(request.products());
//        step-3:save order
        var order = repository.save(mapper.toOrder(request));
//        step-4: save order items
        for(PurchaseRequest purchaseRequest: request.products()) {
            itemRepository.save(itemMapper.toOrderItem(purchaseRequest, order));
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

    public List<DailyReport> dailySalesReport(LocalDate start, LocalDate end) {
        if(start==null) {
            start = LocalDate.now().minusDays(1);
            System.out.println(start);
        }
        if(end == null) {
            end = LocalDate.now().plusDays(1);
            System.out.println(end);
        }
        return  repository.findDailySalesReport(start, end);
    }

    public List<OrderReport> weeklySalesReport() {
        return  repository.findWeeklySalesReport();

    }

    public List<OrderReport> monthlySalesReport() {
        return repository.findMonthlySalesReport();
    }

    public List<OrderReport> yearlySalesReport() {
        return repository.findYearlySalesReport();
    }
}
