package com.invilen.order.order;

import com.invilen.order.dto.OrderMapper;
import com.invilen.order.dto.OrderRequest;
import com.invilen.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    public Page<OrderResponse> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable)
                .map(mapper::toResponse);

    }

    public OrderResponse findById(Integer orderId) {
        return mapper.toResponse(repository.findById(orderId).orElseThrow());
    }
}
