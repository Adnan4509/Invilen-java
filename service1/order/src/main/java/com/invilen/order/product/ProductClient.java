package com.invilen.order.product;

import com.invilen.order.order.PurchaseRequest;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(
        name = "pharmacy-service",
        url = "${application.config.pharmacy-url}"
)
public interface ProductClient {
    public List<PurchaseResponse> puchaseProduct(List<PurchaseRequest> request);
}
