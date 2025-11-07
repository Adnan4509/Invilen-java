package com.invilen.order.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(
        name = "pharmacy-service",
        url = "${application.config.pharmacy-url}"
)
public interface ProductClient {
    @PostMapping
    public List<PurchaseResponse> purchaseProduct(List<PurchaseRequest> request);
}
