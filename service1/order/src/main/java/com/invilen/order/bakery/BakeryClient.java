package com.invilen.order.bakery;

import com.invilen.order.product.ProductClient;
import com.invilen.order.product.PurchaseRequest;
import com.invilen.order.product.PurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(
        name = "bakery-service",
        url = "${application.config.bakery-url}"
)
public interface BakeryClient extends ProductClient {

    @PostMapping("/purchase")
    List<PurchaseResponse> getProductById(List<PurchaseRequest> requests);

}

