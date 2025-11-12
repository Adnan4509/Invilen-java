package com.invilen.order.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(
        name = "pharmacy-service",
        url = "${application.config.pharmacy-url}"
)
public interface ProductClient {
    @PostMapping("/purchase")
    public List<PurchaseResponse> purchasePharmacyProduct(List<PurchaseRequest> request);

    @PostMapping("/bakeryPurchase")
    public List<PurchaseResponse> purchaseBakeryProduct(List<PurchaseRequest> request);
}
