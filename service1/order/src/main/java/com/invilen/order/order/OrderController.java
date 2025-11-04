package com.invilen.order.order;

import com.invilen.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public Page<OrderResponse> findAll(@RequestParam(defaultValue = "10") int pageSize,
                                             @RequestParam(defaultValue = "0") int pageNumber) {

       return orderService.findAll(pageNumber, pageSize);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.findById(orderId));
    }
}
