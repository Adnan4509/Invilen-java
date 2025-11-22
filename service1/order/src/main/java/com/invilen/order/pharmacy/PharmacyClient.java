package com.invilen.order.pharmacy;

import com.invilen.order.product.ProductClient;
import com.invilen.order.product.PurchaseRequest;
import com.invilen.order.product.PurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@FeignClient(
        name = "pharmacy-service",
        url = "${application.config.pharmacy-url}"
)
public interface PharmacyClient extends ProductClient {

    @PostMapping("/purchase")
    List<PurchaseResponse> getProductById(List<PurchaseRequest> requests);

}
